package com.thetestingacademy.ex07_SeleniumActions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Selenium26_windowsHandling {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    @Description("Verify the switching between the windows")
    @Test
    public void test_switchWindow() throws InterruptedException {
        String URL = "https://the-internet.herokuapp.com/windows";
        driver.get(URL);
        driver.manage().window().maximize();
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent window Handle: "+parentWindow);
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> windowHandles=driver.getWindowHandles();
        System.out.println("Window Handles: "+ windowHandles);
        for(String wh:windowHandles){
            driver.switchTo().window(wh);
            if((driver.getPageSource().contains("New Window"))){
                System.out.println("TestCase Passed");
                break;
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
