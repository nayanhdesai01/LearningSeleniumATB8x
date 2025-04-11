package com.thetestingacademy.tasks.Task01_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
/*
open the https://katalon-demo-cura.herokuapp.com/
Click on the make appointment button
Find username,password - enter them  , John Doe, ThisIsNotAPassword
Click on the submit button
Verify the driver. currentUrl == https://katalon-demo-cura.herokuapp.com/#appointment
Push the code to github.com
 */

public class Selenium_Task001 {
    private static final Logger log = LoggerFactory.getLogger(Selenium_Task001.class);

    @Test
    public void testKatalonLogin(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        assertThat(driver.getTitle()).isEqualTo("CURA Healthcare Service");
        WebElement makeAppointment = driver.findElement(By.id("btn-make-appointment"));
        makeAppointment.click();

        WebElement usernameInput = driver.findElement(By.id("txt-username"));
        usernameInput.sendKeys("John Doe");
        WebElement passwordInput = driver.findElement(By.id("txt-password"));
        passwordInput.sendKeys("ThisIsNotAPassword");
        WebElement loginButton = driver.findElement(By.id("btn-login"));
        loginButton.click();

        assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/#appointment");

        driver.quit();
    }
}
