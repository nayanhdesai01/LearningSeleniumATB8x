package com.thetestingacademy.ex03_23122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Selenium10 {
    @Test
    public void test_InvalidEmail() throws Exception{

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com");

        //Assert.assertEquals(driver.getTitle(),"Login - VWO");
        //Assert.assertEquals(driver.getCurrentUrl(),"https://app.vwo.com/#/login");
        WebElement emailInputBox = driver.findElement(By.id("login-username"));
        emailInputBox.sendKeys("admin@admin.com");
        WebElement passwordInputBox = driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("admin123");
        WebElement buttonSubmit = driver.findElement(By.id("js-login-btn"));
        buttonSubmit.click();

        Thread.sleep(3000);

        //<div class="notification-box-description"
        // id="js-notification-box-msg"
        // data-qa="rixawilomi">
        // Your email, password, IP address or location did not match</div>
        WebElement errorMessage=driver.findElement(By.id("js-notification-box-msg"));
        Assert.assertEquals(errorMessage.getText(),"Your email, password, IP address or location did not match");

        assertThat(errorMessage.getText()).isNotEmpty().isNotBlank().isEqualTo("Your email, password, IP address or location did not match");
        driver.quit();

    }
}
