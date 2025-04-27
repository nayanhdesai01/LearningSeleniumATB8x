package com.thetestingacademy.ex06_Selenium_HTMLElements;

import io.qameta.allure.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium20_ShadowDOM2_jsExecutor {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    @Description("Verify the JS Executor")
    @Test
    public void test_jsExecute() throws InterruptedException {
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();
        JavascriptExecutor js =(JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,500);");
       String url = js.executeScript("return document.URL;").toString();
       String title = js.executeScript("return document.title;").toString();
        System.out.println(url);
        System.out.println(title);
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

