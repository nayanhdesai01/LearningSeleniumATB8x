package com.thetestingacademy.ex06_Selenium_HTMLElements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Selenium16_Alerts {
    @Test
            public void testStaticSelect(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement element = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        element.click();

        // Wait for the alert to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        String result1 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result1,"You successfully clicked an alert");

        WebElement confirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        confirm.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert2 = driver.switchTo().alert();
        alert2.dismiss();
        String result2= driver.findElement(By.id("result")).getText();
        //Assert.assertEquals(result,"You clicked: Ok");
        Assert.assertEquals(result2,"You clicked: Cancel");

        WebElement prompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        prompt.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Hello, I am an Alert");
        alert3.accept();
        String result3 = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result3,"Hello, I am an Alert");
    }


}
