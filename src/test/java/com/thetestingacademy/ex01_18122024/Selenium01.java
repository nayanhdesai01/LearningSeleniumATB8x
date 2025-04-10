package com.thetestingacademy.ex01_18122024;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Selenium01 {
    @Test
    public void testSelenium(){

        //Selenium 3
        //System.setProperty("webdriver.chrome.driver","path/to/Chromedriver");

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com");
    }

}
