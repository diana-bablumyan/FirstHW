package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebDriverBasics{
    public static WebDriver driver;

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void checkCount(){
        driver.get("http://automationpractice.com/index.php");
        WebElement inputLink = driver.findElement(By.id("search_query_top"));
        inputLink.sendKeys("dress");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement searchBtn = driver.findElement(By.name("submit_search"));
        searchBtn.click();
        List<WebElement> listElement = driver.findElements(By.xpath("//li[contains(@class,\"ajax_block_product\")]"));
        int count = listElement.size();
        WebElement headingCount = driver.findElement(By.className("heading-counter"));
        String text = headingCount.getText();
        String subCount = text.substring(0,1);
        Assert.assertEquals("7", subCount);
    }

    @Test
    public void loopForDress(){
        driver.get("http://automationpractice.com/index.php");
        WebElement inputLink = driver.findElement(By.id("search_query_top"));
        inputLink.sendKeys("dress");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement searchBtn = driver.findElement(By.name("submit_search"));
        searchBtn.click();
        List<WebElement> listElement = driver.findElements(By.xpath("//li[contains(@class,\"ajax_block_product\")]//div/div[2]/h5"));
        for (WebElement i: listElement){
            String text =  i.getText().toLowerCase();
            System.out.println(text);
            Assert.assertTrue(text.contains("dress"));
        }
    }

//    @AfterClass
//    public static void afterclass() {
//        driver.quit();
//    }
}