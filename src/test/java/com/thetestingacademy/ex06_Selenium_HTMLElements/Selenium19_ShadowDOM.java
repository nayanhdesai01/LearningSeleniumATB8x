package com.thetestingacademy.ex06_Selenium_HTMLElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium19_ShadowDOM {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    @Description("Verify the Static Web Tables")
    @Test
    public void test_shadowDom() throws InterruptedException {
        String URL = "https://selectorshub.com/xpath-practice-page/";
        driver.get(URL);
        driver.manage().window().maximize();
     JavascriptExecutor js = (JavascriptExecutor) driver;
     WebElement input_username = driver.findElement(By.xpath("//div[@id='userName']"));
     js.executeScript("arguments[0].scrollIntoView();",input_username);
     WebElement input_Pizza=(WebElement)js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");
     input_Pizza.sendKeys("farmhouse");
     Thread.sleep(3000);
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