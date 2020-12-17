package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public WebDriver driver;

    @Before
    public  void SetUp()  {


        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }




    @After
    public void stop() {
        driver.quit();
    }
}