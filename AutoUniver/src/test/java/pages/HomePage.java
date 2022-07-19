package pages;


import constants.locators.HomePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By searchField = By.className(HomePageConstants.SEARCHFIELD);
    private By searchBtn = By.className(HomePageConstants.SEARCHBTN);
    private By productPrices = By.className(HomePageConstants.PRODUCTPRICES);


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void fillSearchField(String keyword){
        driver.findElement(searchField).sendKeys(keyword);
    }

    public void clickSearchBtn(){
        driver.findElement(searchBtn).click();
    }

}
