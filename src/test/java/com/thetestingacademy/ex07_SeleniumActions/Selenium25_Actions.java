package com.thetestingacademy.ex07_SeleniumActions;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class Selenium25_Actions {

    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    @Description("Verify the Makemytrip")
    @Test
    public void test_staticTable() throws InterruptedException {
        String URL = "https://www.makemytrip.com/";
        driver.get(URL);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy=\"closeModal\"]")));
        driver.findElement(By.xpath("//span[@data-cy=\"closeModal\"]")).click();

        WebElement fromCity = driver.findElement(By.id("fromCity"));
        try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {throw new RuntimeException(e);
       }

        Actions actions = new Actions(driver);
        actions.moveToElement(fromCity).click().build().perform();
        actions.sendKeys(fromCity,"Del").build().perform();
        List<WebElement> sourceList=driver.findElements(By.xpath("//ul[@class=\"react-autosuggest__suggestions-list\"]/li"));
        for(WebElement e:sourceList){
            if(e.getText().contains("Delhi")){
                e.click();
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
