package com.thetestingacademy.ex01_18122024_SeleniumBasics;

import org.openqa.selenium.chrome.ChromeDriver;
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
