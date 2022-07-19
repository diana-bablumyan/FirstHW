package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewAppTest {
    public static WebDriver driver;

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void valid(){
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement login = driver.findElement(By.id("username"));
        login.sendKeys("tomsmith");
        WebElement pass = driver.findElement(By.id("password"));
        pass.sendKeys("SuperSecretPassword!");
        WebElement submit = driver.findElement(By.className("fa-sign-in"));
        submit.click();
        WebElement message = driver.findElement(By.id("flash"));
        String messageGet = message.getText();
        Assert.assertTrue(messageGet.contains("You logged into a secure area!"));
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

//    @AfterClass
//    public static void afterclass() {
//        driver.quit();
//    }
}