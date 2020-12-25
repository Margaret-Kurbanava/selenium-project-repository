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

public class AdminPageMain {

    private  WebDriver driver;

  private By menuLink = By.cssSelector("#box-apps-menu-wrapper a");
    private By title = By.tagName("h1");

    public AdminPageMain (WebDriver driver) {this.driver= driver;}

    public void checkLinks(){
        List<WebElement> menuLinks =driver.findElements(menuLink);
        for (int i = 0; i <= menuLinks.size(); i++) {
            menuLinks.get(i).click();
            driver.findElement(title).isDisplayed();
            menuLinks =driver.findElements(menuLink);

        }
    }


}