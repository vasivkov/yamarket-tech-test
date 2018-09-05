package com.vasivkov.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

public class InitialTest extends BaseTest{


    @Test
    public  void openPage(){
        driver.get("http://google.com");

    }

}
