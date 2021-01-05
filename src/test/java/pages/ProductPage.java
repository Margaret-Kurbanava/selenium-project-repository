package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.NumberFormat;
import java.text.ParseException;

public class ProductPage {

    private WebDriver driver;


    public ProductPage (WebDriver driver) {this.driver= driver;}


private By title = By.cssSelector("#box-product .title");

    private By productRegularPrice=By.cssSelector("#box-product .regular-price");
    private By productCampaignPrice=By.cssSelector("#box-product .campaign-price");

    public String getTitle(){
        return driver.findElement(title).getText();
    }



    public String getProductPriceColor(By productPrice){
        return driver.findElement(productPrice).getCssValue("color");

    }

    public String getProductRegularPriceColor(){
        return getProductPriceColor(productRegularPrice);
    }


    public String getProductCampaignsPriceColor(){
        return getProductPriceColor(productCampaignPrice);
    }





    public String getProductPriceStyles(By productPrice){
        return driver.findElement(productPrice).getCssValue("text-decoration");

    }

    public String getProductRegularPriceStyles(){
        return getProductPriceStyles(productRegularPrice);
    }


    public String getProductCampaignsPriceStyles(){
        return getProductPriceStyles(productCampaignPrice);
    }







    public String getProductPrice(By productPrice){
        return driver.findElement(productPrice).getText();

    }

    public String getProductRegularPrice(){
        return getProductPrice(productRegularPrice);
    }


    public String getProductCampaignsPrice(){
        return getProductPrice(productCampaignPrice);
    }










    public int getProductPriceSize(By productPrice) throws ParseException {


        int i=((Number) NumberFormat.getInstance().parse(driver.findElement(productPrice).getCssValue("font-size"))).intValue();

        return i;
    }


    public int getProductCampaignsPriceSize() throws ParseException {
        return getProductPriceSize(productCampaignPrice);
    }


    public int getProductRegularPriceSize() throws ParseException {
        return getProductPriceSize( productRegularPrice);
    }








}
