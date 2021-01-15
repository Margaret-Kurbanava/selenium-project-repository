package pages;

import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.support.ui.Select;

        import java.io.File;
import java.util.concurrent.TimeUnit;

public class CatalogPage extends BasePage {

    private WebDriver driver;

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addNewProductButton = By.cssSelector("a[href*=\"app=catalog&doc=edit_product\"]");
    private By statusEnabled = By.cssSelector("input[name='status']");
    private By productNameField = By.cssSelector("input[name='name[en]']");
    private By codeField = By.cssSelector("input[name='code']");
    String productName = generateRandomProductName();
    private By catalogLink = By.xpath("//*[text() = '" + productName + "']");
    private By unisexCheckBox = By.cssSelector("input[name='product_groups[]'][value=\"1-3\"]");
    private By quantity = By.cssSelector("input[name='quantity']");
    private By soldOutStatus = By.cssSelector("select[name=\"sold_out_status_id\"]");
    private By chooseFile = By.cssSelector("input[name=\"new_images[]\"]");
    private By dateValidFrom = By.cssSelector("input[name=\"date_valid_from\"]");
    private By dateValidTo = By.cssSelector("input[name=\"date_valid_to\"]");
    private By infoTab = By.cssSelector("a[href=\"#tab-information\"]");
    private By manufacturerSelect = By.cssSelector("select[name=\"manufacturer_id\"]");
    private By shortDescription = By.cssSelector("input[name=\"short_description[en]\"]");
    private By description = By.cssSelector("textarea[name=\"description[en]\"]");
    private By pricesTab = By.cssSelector("a[href=\"#tab-prices\"]");
    private By purchasePrice = By.cssSelector("input[name=\"purchase_price\"]");
    private By priceCurrencySelect = By.cssSelector("select[name=\"purchase_price_currency_code\"]");
    private By saveButton = By.name("save");



    public void clickAddNewProduct() {
        driver.findElement(addNewProductButton).click();
    }




    public void fillGeneralInfo() throws InterruptedException {

        Thread.sleep(500);
        driver.findElement(statusEnabled).click();

        driver.findElement(productNameField).sendKeys(productName);

        driver.findElement(codeField).sendKeys("12345");
        driver.findElement(unisexCheckBox).click();
        driver.findElement(quantity).sendKeys("123");

        Select select = new Select(driver.findElement(soldOutStatus));
        select.selectByIndex(0);


        String image = getAbsolutePath("src/test/resources/b4e4c5a29f2db9780370b3ea7d5331d1.jpg");

        driver.findElement(chooseFile).sendKeys(image);

        driver.findElement(dateValidFrom).sendKeys("1122021");
        driver.findElement(dateValidTo).sendKeys("1122031");

    }


    public void fillInformation() throws InterruptedException {
        driver.findElement(infoTab).click();
        Thread.sleep(500);

        Select select1 = new Select(driver.findElement(manufacturerSelect));
        select1.selectByIndex(1);

        driver.findElement(shortDescription).sendKeys("Short Description");

        driver.findElement(description).sendKeys("Long long long Description");


    }

    public void fillPrices() throws InterruptedException {

        driver.findElement(pricesTab).click();
        Thread.sleep(500);
        driver.findElement(purchasePrice).sendKeys("10");
        Select select3 = new Select(driver.findElement(priceCurrencySelect));
        select3.selectByIndex(1);


    }


    public void clickSave() throws InterruptedException {
        driver.findElement(saveButton).click();
        Thread.sleep(500);

    }


    public boolean isProductDisplayed() {
        return driver.findElement(catalogLink).isDisplayed();
    }





}




