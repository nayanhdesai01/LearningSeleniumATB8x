package com.thetestingacademy.ex06_Selenium_HTMLElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium17_SVG_P1 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    @Description("Verify the Search results")
    @Test
    public void test_FlipkartSearch() {
        String URL = ("https://www.flipkart.com/");
        driver.get(URL);
        driver.manage().window().maximize();
        //Step1: Enter input as 'macmini' in the input box;
        //Step2:Click on the SVG search element
        driver.findElement(By.name("q")).sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElements.get(0).click();

        List<WebElement> titleResults = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement titles: titleResults){
            System.out.println(titles.getText());
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
