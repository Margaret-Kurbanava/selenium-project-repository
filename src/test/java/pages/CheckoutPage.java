package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Integer.parseInt;


public class CheckoutPage extends BasePage {


    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By quantityInput = By.name("quantity");
    private By updateButton = By.name("update_cart_item");
    private By orderSummary = By.cssSelector("#order_confirmation-wrapper table");




    public void removeProduct() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, 10/*seconds*/);

        //get quantity
        WebElement quantityInputField = driver.findElement(quantityInput);
        int productsNumber = Integer.parseInt(quantityInputField.getAttribute("value"));

        //remove products




        wait.until(ExpectedConditions.elementToBeClickable(quantityInputField));
        quantityInputField.clear();
        Thread.sleep(300);
        wait.until(ExpectedConditions.elementToBeClickable(quantityInputField));
        WebElement orderSummaryTable = driver.findElement(orderSummary);
        quantityInputField.sendKeys(String.valueOf(productsNumber - 1));

       driver.findElement(updateButton).click();

       //wait for table to be updated
        wait.until(ExpectedConditions.stalenessOf(orderSummaryTable));






}





}



