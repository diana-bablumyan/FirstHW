package pages;

import constants.locators.LoginPageConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id(LoginPageConstants.USERNAME);
    private By password = By.id(LoginPageConstants.PASSWORD);
    private By button = By.className(LoginPageConstants.SUBMIT);
    private By errorMes = By.id(LoginPageConstants.ERRORMES);


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillUsername(String inputUsername){
        driver.findElement(username).sendKeys(inputUsername);
    }

    public void fillPassword(String inputPass){
        driver.findElement(password).sendKeys(inputPass);
    }

    public void clickButton(){
        driver.findElement(button).click();
    }

    public SecurePage successLogin(){
        return new SecurePage();
    }
}
