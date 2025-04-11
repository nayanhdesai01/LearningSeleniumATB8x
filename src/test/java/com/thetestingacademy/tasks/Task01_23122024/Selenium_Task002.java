package com.thetestingacademy.tasks.Task01_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class Selenium_Task002 {
    // https://awesomeqa.com/practice.html

    @Test
    public void testMethod(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/practice.html");

        WebElement usernameInput = driver.findElement(By.name("firstname"));
        usernameInput.sendKeys("Pia");
        WebElement passwordInput = driver.findElement(By.name("lastname"));
        passwordInput.sendKeys("Agarwal");
        WebElement genderRadiobutton = driver.findElement(By.id("sex-1"));
        genderRadiobutton.click();
        WebElement expRadiobutton = driver.findElement(By.id("exp-3"));
        expRadiobutton.click();
        WebElement datePicker = driver.findElement(By.id("datepicker"));
        datePicker.sendKeys("14-05-2025");
        WebElement professionCheckbox = driver.findElement(By.id("profession-1"));
        professionCheckbox.click();
        WebElement automationRadiobutton = driver.findElement(By.id("tool-2"));
        automationRadiobutton.click();
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

    }
}
