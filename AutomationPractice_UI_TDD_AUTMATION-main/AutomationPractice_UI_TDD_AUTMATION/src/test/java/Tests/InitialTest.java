package Tests;

import Locators.*;
import Pages.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.concurrent.TimeUnit;


public class InitialTest   {

    public static  WebDriver driver;
    public WebDriverWait wait;
    public static HomePage homePage;
    public static Logger logger;



    String browser = "chrome";

    public void setUp(String browser) {

        logger= Logger.getLogger("Automation Practice UI Automation");//added Logger
        PropertyConfigurator.configure("log4j.properties"); //added logger
        logger.setLevel(Level.DEBUG);


        if (browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--start-maximized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 15);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 15);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }  else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        wait = new WebDriverWait(driver, 15);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--start-maximized");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, 15);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        logger.info("Go To Automation Practice Web Page");
        String url = "http://automationpractice.com/index.php";
        driver.get(url);
        driver.manage().window().maximize();

        logger.info("Verify Automation Practice Web Page From Title");
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "My Store";
        Assert.assertEquals(expectedTitle, actualTitle);

        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void afterTest(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()){
            try{
                // To create reference of TakesScreenshot
                TakesScreenshot screenshot=(TakesScreenshot)driver;
                // Call method to capture screenshot
                File src=screenshot.getScreenshotAs(OutputType.FILE);
                // Copy files to specific location
                // result.getName() will return name of test case so that screenshot name will be same as test case name
                String projectPath = System.getProperty("user.dir");
                FileUtils.copyFile(src, new File(projectPath+"\\screenshots\\" + result.getName() +".png"));  //\src\test\resources\screenshots\
                System.out.println("Successfully captured a screenshot");
            }catch (Exception e){
                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        driver.quit();
    }



}
