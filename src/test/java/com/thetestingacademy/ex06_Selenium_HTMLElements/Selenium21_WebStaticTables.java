package com.thetestingacademy.ex06_Selenium_HTMLElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium21_WebStaticTables {

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
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        driver.manage().window().maximize();
        int row = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr[2]/td")).size();

        // xpath
        // table[@id='customers']/tbody/tr[
        // i
        // ]/td[
        // j
        // ]
        String first_part="//table[@id='customers']/tbody/tr[";
        String second_part="]/td[";
        String third_part="]";

        for(int i=2;i<=row;i++){
            for(int j=1;j<=col;j++){
                String dynamic_xpath=first_part+i+second_part+j+third_part;
                String data=driver.findElement(By.xpath(dynamic_xpath)).getText();
                //   System.out.println(data);
                if(data.contains("Helen Bennett")){
                    String country_path=dynamic_xpath+"/following-sibling::td";
                    String company_path=dynamic_xpath+"/preceding-sibling::td";
                    String country=driver.findElement(By.xpath(country_path)).getText();
                    String company=driver.findElement(By.xpath(company_path)).getText();
                    System.out.println("----------------");
                    System.out.println("Helen Bennett lives in: "+ country);
                    System.out.println("Helen Bennett works for: "+ company);
                }
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

