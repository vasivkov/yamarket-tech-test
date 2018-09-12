package com.vasivkov.tests;

import com.vasivkov.Utils.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters ("browser")
    public WebDriver getDriver(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/LinuxGeckodriver");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/LinuxChromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(PropertiesFileReader.getTestProperty("implicitlyWait")), TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    protected void tearDown() {
        if(driver != null)
            driver.quit();
    }
}

