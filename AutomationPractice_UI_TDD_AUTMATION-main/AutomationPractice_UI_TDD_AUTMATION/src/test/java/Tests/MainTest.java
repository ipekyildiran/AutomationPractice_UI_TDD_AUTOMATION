package Tests;


import ErrorDictionary.errorReport;
import Pages.*;
import Users.AccountInformation;
import Users.UserPool;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MainTest extends InitialTest implements errorReport  {

    WebDriverWait wait;
    WebDriver driver;



    @Test
    public void T01_AutomationPractice(){


        setUp("chrome");

        logger.info("Case 1 : Enter Login Automation Practice");


        logger.info("Go To Automation Practice Login Screen");
        homePage.SendResearchFıeld(womenModel);
        homePage.ClickSearchButton();



        ProductPage productPage = homePage.productPage();
        logger.info("Click From Women Dress");
        productPage.ClickDressFıeld();

        AddBookToBasketPage addBookToBasketPage = productPage.addBookToBasketPage();
        addBookToBasketPage.ClickAddToChart();







    }



}
