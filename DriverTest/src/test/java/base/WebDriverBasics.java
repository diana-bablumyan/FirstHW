package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverBasics{
    public static WebDriver driver;

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void webDriverHelloWordTest(){
        driver.get("https://www.asos.com/men/");
        WebElement inputLink = driver.findElement(By.id("chrome-search"));
        inputLink.click();
        inputLink.sendKeys("T-Shirt");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement searchBtn = driver.findElement(By.cssSelector("#chrome-sticky-header > div._3wSz5e5 > div > div > div > form > div > button.kH5PAAC._1KRfEms"));
        searchBtn.click();
        WebElement sortF = driver.findElement(By.xpath("//*[@id=\"mediumRefinements\"]/li[1]/div/button"));
        sortF.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement sortOp = driver.findElement(By.id("plp_web_sort_whats_new"));
        sortOp.click();
        WebElement colourF = driver.findElement(By.xpath("//*[@id=\"mediumRefinements\"]/li[8]/div/button"));
        colourF.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement colourOp = driver.findElement(By.xpath("//*[@id=\"mediumRefinements\"]/li[8]/div/div/div/ul/li[3]/div/label/div[2]"));
        colourOp.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebElement element = driver.findElement(By.xpath("//p[@data-auto-id=\"styleCount\"]"));
        System.out.println("Shirt Count");
        System.out.println(element.getText());
    }


//    @AfterClass
//    public static void afterclass() {
//        driver.quit();
//    }
}