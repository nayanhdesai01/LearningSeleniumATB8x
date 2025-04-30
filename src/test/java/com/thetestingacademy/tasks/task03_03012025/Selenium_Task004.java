package com.thetestingacademy.tasks.task03_03012025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Selenium_Task004 {
    private static final Logger log = LoggerFactory.getLogger(Selenium_Task004.class);
    //Navigate to the Account Tab - https://demo.us.espocrm.com/?l=en_US#Account
    //Create - https://demo.us.espocrm.com/?l=en_US#Contact
    //Negative - try to save without entering anything - it should give you error, verify that.

    @Test
    public void testCRMMethod() throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://demo.us.espocrm.com");
        String expectedTitle = driver.getTitle();
        String actualTitle = "EspoCRM Demo";
        System.out.println("Title: " + expectedTitle);
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(50));
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-login")));
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Accounts']")));
        WebElement accountElement = driver.findElement(By.xpath("//span[text()='Accounts']"));
        accountElement.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Create Account']")));
        WebElement createAccount = driver.findElement(By.xpath("//span[text()='Create Account']"));
        createAccount.click();


    }
}