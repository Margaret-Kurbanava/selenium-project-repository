package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static java.lang.Thread.*;

public class AdminPageMain {

    private  WebDriver driver;

  private By menuLink = By.cssSelector("#app- >a");
  private By nestedLink = By.cssSelector(".docs a");

  private By menuLinkConstuctor(String link){

     return By.cssSelector("a[href*=\"http://localhost/litecart/admin/?app=" + link);
  }


    private By title = By.tagName("h1");

    public AdminPageMain (WebDriver driver) {this.driver= driver;}

    public void checkLinks() throws InterruptedException {
        List<WebElement> menuLinks =driver.findElements(menuLink);

        for (int i = 0; i < menuLinks.size(); i++) {
            sleep(40);
            menuLinks.get(i).click();
            driver.findElement(title).isDisplayed();



            List<WebElement> nestedLinks =driver.findElements(nestedLink);
            for (int j = 0; j < nestedLinks.size(); j++)  {
               nestedLinks.get(j).click();
                driver.findElement(title).isDisplayed();
                nestedLinks =driver.findElements(nestedLink);

            }

            menuLinks =driver.findElements(menuLink);

        }



    }


    public void clickMenuLink(String link) throws InterruptedException {

        Thread.sleep(500);

        driver.findElement(menuLinkConstuctor(link)).click();

    }


}