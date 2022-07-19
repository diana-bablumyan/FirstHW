package pages;

import constants.locators.SecurePageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage {
    private WebDriver driver;
    private By successMes = By.className(SecurePageConstants.SUCCESSMESS);
    private By logoutBtn = By.className(SecurePageConstants.LOGOUTBTN);

    public SecurePage(){
        this.driver = driver;
    }
}
