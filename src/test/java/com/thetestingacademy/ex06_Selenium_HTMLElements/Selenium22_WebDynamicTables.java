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

public class Selenium22_WebDynamicTables {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    @Description("Verify the Static tables")
    @Test
    public void test_staticTable() throws InterruptedException {
        String URL = "https://awesomeqa.com/webtable1.html";
        driver.get(URL);
        driver.manage().window().maximize();
       //Find the xpath for the table
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        //for rows and columns
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(int i=0;i<rows.size();i++){
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            for(WebElement c:cols){
                System.out.println(c.getText());
            }
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

