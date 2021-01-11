package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountPage extends BasePage {

    private WebDriver driver;

    private By emailField = By.name("email");
    //private By emailField = By.cssSelector("input[name='email']");
    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By addressField = By.name("address1");
    private By postCodeField = By.name("postcode");
    private By cityField = By.name("city");
    private By phoneField = By.name("phone");
    private By desiredPassField = By.name("password");
    private By confirmPassField = By.name("confirmed_password");
    private By counrtyDropdown = By.name("country_code");
    private By createAccountButton = By.name("create_account");
    private By logoutLink = By.cssSelector("#box-account a[href*=\"litecart/en/logout\"]");
    private By loginLink = By.name("login");

    String randomEmail = generateRandomEmail();


    public CreateAccountPage(WebDriver driver) {


        this.driver = driver;
    }



    public void enterEmail() throws InterruptedException {


        System.out.println(randomEmail);
        Thread.sleep(300);

        driver.findElement(emailField).sendKeys(randomEmail);
    }



    //fill in required fields
    public void fillInName(){
        driver.findElement(firstNameField).sendKeys("User");
        driver.findElement(lastNameField).sendKeys("TestUser");
    }

    public void selectFromDropDown(By dropdown, String option) {

        Select select = new Select(driver.findElement(dropdown));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.opacity =1",select);


        select.selectByVisibleText(option);
    }



    public void fillInAddress(){

        driver.findElement(addressField).sendKeys("some address");
        driver.findElement(postCodeField).sendKeys("12345");
        driver.findElement(cityField).sendKeys("SomeCity");

        selectFromDropDown(counrtyDropdown,"United States");

    }




    public void fillInPhone(){

        driver.findElement(phoneField).sendKeys(" 111111111");
          }

    public void fillInPassword(){

        driver.findElement(desiredPassField).sendKeys("password1");


    }

    public void confirmPassword(){


        driver.findElement(confirmPassField).sendKeys("password1");

    }


    public void clickCreateAccount() throws InterruptedException {
        driver.findElement(createAccountButton).click();
        Thread.sleep(300);
    }



    public void logOut(){
        driver.findElement(logoutLink).click();

    }


    public void logIn(){
        driver.findElement(loginLink).click();

}



}
