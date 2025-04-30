package com.thetestingacademy.ex07_SeleniumActions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium29_UploadFile {

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
    public void test_dragndrop() throws InterruptedException {
        String URL = "https://awesomeqa.com/selenium/upload.html";
        driver.get(URL);
        driver.manage().window().maximize();
        Actions actions=new Actions(driver);
        WebElement chooseFile=driver.findElement(By.id("fileToUpload"));
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        chooseFile.sendKeys(dir+"src/test/java/com/thetestingacademy/ex07_SeleniumActions/test.txt");
        driver.findElement(By.name("submit")).click();


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
