package com.thetestingacademy.ex04_30122024;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium13 {
    @Test
    public void testEbay() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='gh-ac']"));
        searchBox.sendKeys("macmini");

        WebElement searchButton = driver.findElement(By.xpath("//button[@id='gh-search-btn']"));
        searchButton.click();

       List<WebElement> searchTitles = driver.findElements(By.xpath("//div[@class='s-item__title']"));
       List<WebElement> searchPrice = driver.findElements(By.xpath("//span[@class='s-item__price']"));

        System.out.println("Titles :"+searchTitles.size());
        System.out.println("Price :"+searchPrice.size());

       int size = Math.min(searchPrice.size(),searchTitles.size());
        System.out.println(size);

       for(int i=0;i<size;i++){
           System.out.println("Title : " + searchTitles.get(i).getText() + " || " + "Price : " + searchPrice.get(i).getText());
       }

    }

}
