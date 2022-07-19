package pages;

import constants.locators.SearchResultPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {

    private WebDriver driver;
    private By resultCount = By.id(SearchResultPageConstants.RESULTCOUNT);
    private By productName = By.xpath(SearchResultPageConstants.PRODUCTNAME);
    private By productPrices = By.xpath(SearchResultPageConstants.PRODUCTPRICES);


    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }


}
