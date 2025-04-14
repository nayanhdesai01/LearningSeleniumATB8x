package com.thetestingacademy.ex05_03012025;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Selenium14 {
    @Test
    public void testXpathAxes(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://cdpn.io/AbdullahSajjad/fullpage/LYGVRgK?anon=true&view=fullpage");

        driver.switchTo().frame("result");

        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
        submitButton.click();

        String inputBox = "//input[@id='username']";
        String followingSibling = inputBox+"/following-sibling::small";
        String precedingSibling = inputBox+"/preceding-sibling::label";

        WebElement errorMsg = driver.findElement(By.xpath(followingSibling));
        WebElement labelMsg = driver.findElement(By.xpath(precedingSibling));
        System.out.println("Label message: "+ labelMsg.getText());
        assertThat(errorMsg.getText()).isEqualTo("Username must be at least 3 characters");

    }
}
