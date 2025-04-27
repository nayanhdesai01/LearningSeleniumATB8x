package com.thetestingacademy.ex06_Selenium_HTMLElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Selenium15_Static_Select {
    @Test
            public void testStaticSelect(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement staticDropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(staticDropdown);
        //select.selectByVisibleText("Option 2");
        select.selectByIndex(2);
    }


}
