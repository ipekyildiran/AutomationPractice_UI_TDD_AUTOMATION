package Pages;


import Locators.Locator;
import Xpaths.HomeConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends Locator implements HomeConstants {

    private WebDriverWait wait;
    private WebDriver driver;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }
    public void SendResearchFıeld(String modelName){
     sleep(100);
     SendById(researchFıeld ,modelName );
    }

    public void ClickSearchButton(){
        sleep(100);
        ClickByXpath(searchButton);
    }


    public ProductPage productPage() {

        sleep(1000);
        return new ProductPage(driver);
    }

}
