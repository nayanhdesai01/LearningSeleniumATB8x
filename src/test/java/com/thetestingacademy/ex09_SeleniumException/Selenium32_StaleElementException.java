package com.thetestingacademy.ex09_SeleniumException;

import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium32_StaleElementException {
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
        String URL = "https://google.com/";
        driver.get(URL);
        driver.manage().window().maximize();
       try{
            WebElement searchBox = driver.findElement(By.id("APjFqb"));
           // driver.navigate().refresh();
            //HTML DOM refreshed
            //Driver will think that, element may or may not be available now
            //As i have found the element earlier
           //Actual fix is re find the element
           searchBox = driver.findElement(By.id("APjFqb"));
            searchBox.sendKeys("Kittens"+ Keys.ENTER);
        } catch (StaleElementReferenceException e) {
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
