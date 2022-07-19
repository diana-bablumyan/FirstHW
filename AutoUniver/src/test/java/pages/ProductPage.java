package pages;

import constants.locators.HomePageConstants;
import constants.locators.ProductPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private WebDriver driver;
    private By productPrice = By.className(ProductPageConstants.PRODUCTPRICE);


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


}
