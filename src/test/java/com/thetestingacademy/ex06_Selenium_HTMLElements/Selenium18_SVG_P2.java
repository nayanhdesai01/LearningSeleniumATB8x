package com.thetestingacademy.ex06_Selenium_HTMLElements;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Selenium18_SVG_P2 {
    EdgeDriver driver;
    @BeforeTest
    public void openBrowser(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
    }
    @Description("Verify and click on Tripura")
    @Test
    public void test_FlipkartSearch() {
        String URL = "https://www.amcharts.com/svg-maps/?map=india";
        driver.get(URL);
        driver.manage().window().maximize();
        List<WebElement> states = driver.findElements(By.xpath("//*[local-name()='svg']/*[local-name()='g'][7]/*[local-name()='g']/*[local-name()='g']/*[local-name()='path']"));
        for(WebElement state:states){
            System.out.println(state.getDomAttribute("aria-label"));
//            if(state.getDomAttribute("aria-label").contains("Tripura")){
//                state.click();
//            }
            if(state.getDomAttribute("aria-label").contains("Delhi")){
                state.click();
            }
        }
        }

    @AfterTest
    public void closeBrowser(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
