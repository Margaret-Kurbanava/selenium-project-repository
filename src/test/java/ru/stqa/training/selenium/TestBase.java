package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public  WebDriver driver;
    public  WebDriverWait wait;

    @Before
    public  void SetUp()  {


        //run driver once. Replacement for TestNG BeforeAll.
        if (driver != null) {
        return;
        }

        //Chrome Capabilities -dismiss unexpected browser alerts
       ChromeOptions caps = new ChromeOptions();
       caps.setCapability("unexpectedAlertBehaviour", "dismiss");


       //for other browsers
        // DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setCapability("unexpectedAlertBehaviour", "dismiss");

        //driver constructor
      driver = new ChromeDriver(caps);

        // Edge browser run
       /* System.setProperty("webdriver.edge.driver", "C:\\SeleniumDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();*/


        //timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //maximize window
        driver.manage().window().maximize();

        //print all Capabilities
        System.out.println(((HasCapabilities) driver).getCapabilities());

        //wait
        wait = new WebDriverWait(driver, 10);

        //Shutdown the browser. Replacement for TestNG AfterAll.
      // Runtime.getRuntime().addShutdownHook(new Thread(() -> { driver.quit(); driver = null; }));
    }




    @After
    public void stop() {
      driver.quit();
    }
}