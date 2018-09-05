package com.vasivkov.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    @Parameters ("browser")
    public WebDriver getDriver(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/home/vasya/IdeaProjects/yamarket-tech-test/src/main/resources/drivers/LinuxGeckodriver");
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/vasya/IdeaProjects/yamarket-tech-test/src/main/resources/drivers/LinuxChromedriver");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    protected void tearDown() {
        if(driver != null)
            driver.quit();
    }
}

