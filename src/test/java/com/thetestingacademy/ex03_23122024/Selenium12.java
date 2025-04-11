package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium12 {
    @Test
    public void testMethod() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://vwo.com/free-trial");

        WebElement emailInput = driver.findElement(By.id("page-v1-step1-email"));
        emailInput.sendKeys("adbvnf");

        WebElement policyCheckbox = driver.findElement((By.name("gdpr_consent_checkbox")));
        policyCheckbox.click();

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        buttonList.get(0).click();

        WebElement errorMessage = driver.findElement(By.className("invalid-reason"));
        Assert.assertEquals(errorMessage.getText(),"The email address you entered is incorrect.");

        Thread.sleep(3000);
        driver.quit();


    }
}
