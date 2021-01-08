package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.support.Color;

public class LitecartMain {

    private WebDriver driver;


    private String litecartMainLink= "http://localhost/litecart/en/";
    private By sticker = By.cssSelector(".sticker");
    private By product = By.cssSelector(".product");
   private By campaignsProduct = By.cssSelector("#box-campaigns .product");

    private By productName = By.cssSelector(".name");

    private By productRegularPrice = By.cssSelector(".regular-price");
    private By productCampaignPrice = By.cssSelector(".campaign-price");





    public LitecartMain (WebDriver driver) {this.driver= driver;}


 public void openLitecart(){
        driver.get(litecartMainLink);
 }



    public ProductPage openCampaignsProduct(){
        driver.findElement(campaignsProduct).click();
        return new ProductPage(driver);
    }



    public String getProductName(WebElement product){


        return product.findElement(productName).getText();
    }

    public String getCampaignsProductName(){
        return getProductName(driver.findElement(campaignsProduct));
    }





    public String getProductPriceColor(By product, By productPrice)  {




        String color = driver.findElement(product).findElement(productPrice).getCssValue("color");







        return color;

    }



    public String getProductCampaignsPriceColor()  {
        return getProductPriceColor(campaignsProduct, productCampaignPrice);
    }


    public String getProductRegularPriceColor() {
        return getProductPriceColor(campaignsProduct, productRegularPrice);
    }









    public String getProductPriceTextDecor(By product, By productPrice){
        return driver.findElement(product).findElement(productPrice).getCssValue("text-decoration");

    }

    public String getProductRegularPriceTextDecor(){
        return getProductPriceTextDecor(campaignsProduct, productRegularPrice);
    }

    public String getProductCampaignsPriceTextDecor(){
        return getProductPriceTextDecor(campaignsProduct, productCampaignPrice);
    }








    public String getProductPrice(By product, By productPrice){
        return driver.findElement(product).findElement(productPrice).getText();

    }

    public String getProductRegularPrice(){
        return getProductPrice(campaignsProduct, productRegularPrice);
    }


    public String getProductCampaignsPrice(){
        return getProductPrice(campaignsProduct, productCampaignPrice);
    }







    public int getProductPriceSize(By product, By productPrice) throws ParseException {


         int i=((Number) NumberFormat.getInstance().parse(driver.findElement(product).findElement(productPrice).getCssValue("font-size"))).intValue();

        return i;
    }


    public int getProductCampaignsPriceSize() throws ParseException {
        return getProductPriceSize(campaignsProduct, productCampaignPrice);
    }


    public int getProductRegularPriceSize() throws ParseException {
        return getProductPriceSize(campaignsProduct, productRegularPrice);
    }










public void checkStickers(){

    List<WebElement> products = driver.findElements(product);
    for (int i = 0; i < products.size(); i++) {

        products.get(i).findElement(sticker).isDisplayed();
        List<WebElement> stickers= products.get(i).findElements(sticker);
        assertEquals(1, stickers.size());
    }
    }






}



