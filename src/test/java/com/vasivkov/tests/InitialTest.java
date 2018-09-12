package com.vasivkov.tests;

import com.vasivkov.Utils.PropertiesFileReader;
import org.testng.annotations.Test;

public class InitialTest extends BaseTest{


    @Test
    public  void openPage(){
        driver.get(PropertiesFileReader.getTestProperty("url"));

    }

}
