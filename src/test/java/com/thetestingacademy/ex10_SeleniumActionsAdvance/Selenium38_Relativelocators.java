package com.thetestingacademy.ex10_SeleniumActionsAdvance;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class Selenium38_Relativelocators {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    
    @Description("Verify the switching between the windows")
    @Test
    public void test_relativetest() throws InterruptedException {
        String URL = "https://codepen.io/AbdullahSajjad/full/LYGVRgK";
        driver.get(URL);
        driver.manage().window().maximize();

        driver.switchTo().frame("result");

        WebElement submit = driver.findElement(By.xpath("//form[@id='form']/button"));
        submit.click();

        WebElement userName_element = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement error_element = driver.findElement(with(By.tagName("small")).below(userName_element));

        String errorText = error_element.getText();
        Assert.assertTrue(error_element.isDisplayed());
        Assert.assertEquals(errorText,"Username must be at least 3 characters");

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
