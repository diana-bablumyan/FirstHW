package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Login {
    public static WebDriver driver;

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @DataProvider(name = "testData")
    public Object [][] getData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "tomsmith";  data[0][1] = "incorrect";
        data[1][0] = "incorrect";  data[1][1] = "SuperSecretPassword!";
        data[2][0] = "skhal";   data[2][1] = "chisht";
        return data;
    }

    @Test (dataProvider = "testData")
    public void invalid(String username, String password){
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys(username);
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);
        WebElement submit = driver.findElement(By.className("fa-sign-in"));
        submit.click();
        WebElement message = driver.findElement(By.id("flash"));
        String messageGet = message.getText();
        System.out.println(messageGet);
        Assert.assertTrue(messageGet.contains("invalid"));
    }

    @DataProvider(name = "gitData")
    public Object [][] gitData() {
        Object[][] data = new Object[3][2];
        data[0][0] = "tomsmith";  data[0][1] = "incorrect";
        data[1][0] = "incorrect";  data[1][1] = "SuperSecretPassword!";
        data[2][0] = "skhal";   data[2][1] = "chisht";
        return data;
    }

    @Test (dataProvider = "gitData")
    public void github(String username, String password){
        driver.get("https://github.com/");
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        WebElement login = driver.findElement(By.id("login_field"));
        login.sendKeys(username);
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys(password);
        WebElement submit = driver.findElement(By.className("js-sign-in-button"));
        submit.click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("js-flash-container")));
        String messageGet = firstResult.getText();
        Assert.assertTrue(messageGet.contains("Incorrect"));
    }

    @Test
    public void loginTest(){

    }

    @AfterClass
    public static void afterclass() {
        driver.quit();
    }
}