package Pages;

import Locators.Locator;
import Xpaths.ProductConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage  extends Locator implements ProductConstants {

    private WebDriver driver;
    private WebDriverWait wait;


    public ProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);

    }

    public void ClickDressFıeld(){
        sleep(100);
        ClickByXpath(dressFıeld);
    }

    public AddBookToBasketPage addBookToBasketPage() {

        sleep(1000);
        return new AddBookToBasketPage(driver);
    }


}
