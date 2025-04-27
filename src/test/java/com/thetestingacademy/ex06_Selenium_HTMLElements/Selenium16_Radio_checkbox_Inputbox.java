package com.thetestingacademy.ex06_Selenium_HTMLElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Selenium16_Radio_checkbox_Inputbox {
    public static void main(String[] args) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://awesomeqa.com/practice.html");

        WebElement usernameInput = driver.findElement(By.name("firstname"));
        usernameInput.sendKeys("Pia");
        WebElement passwordInput = driver.findElement(By.name("lastname"));
        passwordInput.sendKeys("Agarwal");
        //Radio button
        WebElement genderRadiobutton = driver.findElement(By.id("sex-1"));
        genderRadiobutton.click();
        //Radio Button
        WebElement expRadiobutton = driver.findElement(By.id("exp-3"));
        expRadiobutton.click();
    }
}
