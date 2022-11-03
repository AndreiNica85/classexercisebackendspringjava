package com.flyingticketsapp.classexercise;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebPageSelenium {
    @Test
    void flightsAppTest() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:3000");
//        WebElement element = driver.findElement(By.id(""));
//
//        driver.findElement(By.className("")).click();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        driver.findElement(By.xpath("")).click();
    }
}
