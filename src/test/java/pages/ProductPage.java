package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class ProductPage {

    private WebDriver driver;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }


    private By title = By.cssSelector("#box-product .title");
    private By productRegularPrice = By.cssSelector("#box-product .regular-price");
    private By productCampaignPrice = By.cssSelector("#box-product .campaign-price");
    private By addToCartButton = By.name("add_cart_product");
    private By cartQuantity = By.cssSelector("#cart span.quantity");
    private By checkoutLink = By.cssSelector("#cart .link");





    public CheckoutPage clickCheckout(){
        driver.findElement(checkoutLink).click();

        return new CheckoutPage(driver);
    }


    public void addToCart(){

        WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);
        WebElement quantity = driver.findElement(cartQuantity);

        String q= (parseInt(quantity.getText())+1) + "";

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));

        driver.findElement(addToCartButton).click();


        wait.until(ExpectedConditions.textToBe(cartQuantity, q));

    }







    public String getTitle() {
        return driver.findElement(title).getText();
    }


    public String getProductPriceColor(By productPrice) {
        return driver.findElement(productPrice).getCssValue("color");

    }

    public String getProductRegularPriceColor() {
        return getProductPriceColor(productRegularPrice);
    }


    public String getProductCampaignsPriceColor() {
        return getProductPriceColor(productCampaignPrice);
    }


    public String getProductPriceStyles(By productPrice) {
        return driver.findElement(productPrice).getCssValue("text-decoration");

    }

    public String getProductRegularPriceStyles() {
        return getProductPriceStyles(productRegularPrice);
    }


    public String getProductCampaignsPriceStyles() {
        return getProductPriceStyles(productCampaignPrice);
    }


    public String getProductPrice(By productPrice) {
        return driver.findElement(productPrice).getText();

    }

    public String getProductRegularPrice() {
        return getProductPrice(productRegularPrice);
    }


    public String getProductCampaignsPrice() {
        return getProductPrice(productCampaignPrice);
    }


    public int getProductPriceSize(By productPrice) throws ParseException {


        int i = ((Number) NumberFormat.getInstance().parse(driver.findElement(productPrice).getCssValue("font-size"))).intValue();

        return i;
    }


    public int getProductCampaignsPriceSize() throws ParseException {
        return getProductPriceSize(productCampaignPrice);
    }


    public int getProductRegularPriceSize() throws ParseException {
        return getProductPriceSize(productRegularPrice);
    }


}
