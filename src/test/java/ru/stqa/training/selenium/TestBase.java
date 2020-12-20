package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;

    @Before
    public  void SetUp()  {

        //Capabilities -dismiss unexpected browser alerts
        ChromeOptions caps = new ChromeOptions();
        caps.setCapability("unexpectedAlertBehaviour", "dismiss");

        // DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("unexpectedAlertBehaviour", "dismiss");

        //driver constructor
        driver = new ChromeDriver(caps);
        //timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();

        //print all Capabilities
        System.out.println(((HasCapabilities) driver).getCapabilities());
    }




    @After
    public void stop() {
        //driver.quit();
    }
}