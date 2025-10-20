package com.thetestingacademy.ex06_Selenium_Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Selenium_ImplicitWait {
    @Test
    public void testEbay() throws InterruptedException {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");

        EdgeDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://www.ebay.com/b/Desktops-All-In-One-Computers/171957/bn_1643067");

        //Implicit wait
     //   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
try{
Thread.sleep(3000);
}catch (InterruptedException e){
    throw new RuntimeException(e);
}
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
