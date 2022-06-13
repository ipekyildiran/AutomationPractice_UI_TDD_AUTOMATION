package Pages;


import Locators.Locator;
import Xpaths.AddBookToBasketConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AddBookToBasketPage extends Locator implements AddBookToBasketConstants {

    private WebDriverWait wait;
    private WebDriver driver;
    private WebElement webElement;


    public AddBookToBasketPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }

    public void ClickAddToChart(){
        ClickByXpath(addToChart);
    }


    public BasketControlPage basketControlPage() {

        sleep(1000);
        return new BasketControlPage(driver);
    }











}
