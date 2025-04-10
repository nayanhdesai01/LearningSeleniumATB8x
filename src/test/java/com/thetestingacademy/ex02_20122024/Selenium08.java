package com.thetestingacademy.ex02_20122024;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium08 {

    @Test
    public void testMethod02(){

        EdgeDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        //No back, forward allowed in case of get

        //navigate . to(),back(),forward()

        driver.navigate().to("https://thetestingacademy");
        driver.navigate().back();
        driver.navigate().forward();
        System.out.println(driver.getTitle());
    }
}
