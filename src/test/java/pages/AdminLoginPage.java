package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
    private  WebDriver driver;


    private String adminLoginPage = "http://localhost/litecart/admin/login.php";
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.name("login");



    public AdminLoginPage(WebDriver driver) {this.driver= driver;}

    public void openAdminLoginPage(){
        driver.get(adminLoginPage);
    }

    public void enterUsename(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){

        driver.findElement(loginButton).click();

    }


    public AdminPageMain loginToAdmin(){
       openAdminLoginPage();
       enterUsename("admin");
       enterPassword("admin");
       clickLogin();
        return new AdminPageMain(driver);
    }


}
