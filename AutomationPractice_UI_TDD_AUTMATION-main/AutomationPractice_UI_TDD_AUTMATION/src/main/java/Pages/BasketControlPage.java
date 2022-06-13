package Pages;


import Locators.Locator;
import Xpaths.BasketControlConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class BasketControlPage extends Locator implements BasketControlConstants {

    private WebDriverWait wait;
    private WebDriver driver;


    public BasketControlPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }












}
