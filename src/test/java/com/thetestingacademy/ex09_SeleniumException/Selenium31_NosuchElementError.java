package com.thetestingacademy.ex09_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium31_NosuchElementError {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }

    @Description("Verify if Web driver is able to Locate the element")
    @Test
    public void test_exceptions(){
        String URL = "https://app.vwo.com/";
        driver.get(URL);
        driver.manage().window().maximize();
        try{
            driver.findElement(By.xpath("kitten"));
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


    }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
