package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class myFirstTest extends TestBase{



    @Test
    public void veryFirstTest() throws InterruptedException {
      driver.get("https://duckduckgo.com/");


        driver.findElement(By.id("search_form_input_homepage")).sendKeys("funny cats");
        driver.findElement(By.id("search_button_homepage")).click();
        driver.findElement(By.linkText("Images")).click();
      }
}
