package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LitecartMain {

    private WebDriver driver;

    private By sticker = By.cssSelector(".sticker");
    private By product = By.cssSelector(".product.column.shadow.hover-light");
   private String litecartMainLink= "http://localhost/litecart/en/";



    public LitecartMain (WebDriver driver) {this.driver= driver;}


 public void openLitecart(){
        driver.get(litecartMainLink);
 }



public void checkStickers(){

    List<WebElement> products = driver.findElements(product);
    for (int i = 0; i < products.size(); i++) {


     products.get(i).findElement(sticker).isDisplayed();
    }
    }






}



