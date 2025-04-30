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

import java.util.List;
import java.util.Set;

public class Selenium27_frames {

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
        String URL = "https://app.vwo.com/#/test/ab/-2/heatmaps";
        driver.get(URL);
        driver.manage().window().maximize();
        WebElement userName= driver.findElement(By.id("login-username"));
        userName.sendKeys("vecefeh538@excederm.com");
        WebElement password=driver.findElement(By.id("login-password"));
        password.sendKeys("Testing@123");
        WebElement loginButton=driver.findElement(By.id("js-login-btn"));
        loginButton.click();
        Thread.sleep(5000);
        String mainWindow = driver.getWindowHandle();
        System.out.println("Parent Window: "+mainWindow);

        Actions actions = new Actions(driver);
        List<WebElement> heatMapList=driver.findElements(By.xpath("//div[@data-qa=\"yedexafobi\"]"));

        //WebElement viewHeatMapButton = driver.findElement(By.xpath("//div[@data-qa=\"meqeqiwiwe\"]"));
        actions.moveToElement(heatMapList.get(1)).click().build().perform();

        Set<String>windowHandles=driver.getWindowHandles();
        System.out.println("Window Handles: "+ windowHandles);

        for(String handle:windowHandles){
            if(!handle.equals(mainWindow)){
                driver.switchTo().window(handle);
                System.out.println("Child Window: "+driver.getTitle());
                driver.switchTo().frame("MktoForms2XDIframe");
            }

        }
   }

//    @AfterTest
//    public void closeBrowser(){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        driver.quit();
//    }
}
