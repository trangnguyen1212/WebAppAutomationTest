package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\trang\\1. TEST\\Automation\\AutoWeb\\chromedriver.exe");
        driver = new ChromeDriver();

    }
    @AfterSuite
    public void close(){
        driver.close();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
