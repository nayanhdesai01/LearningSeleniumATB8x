package com.thetestingacademy.tasks.task02_30122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Selenium_Task003 {
    //Open the https://www.idrive360.com/enterprise/login
    //Enter the credentials
    // email - augtest_040823@idrive.com
    // password - 123456
    // Verify that the free trial message is visible.

    @Test
    public void testFreeTrial() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
            driver.get("https://www.idrive360.com/enterprise/login");

            Thread.sleep(5000);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("augtest_040823@idrive.com");

        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("123456");

        WebElement signInButton = driver.findElement(By.xpath("//button[@id='frm-btn']"));
        signInButton.click();

        Thread.sleep(5000);
        WebElement errorMsg=driver.findElement(By.xpath("//h5[@class='id-card-title']"));
        assertThat(errorMsg.getText()).isEqualTo("Your free trial has expired");


    }
}
