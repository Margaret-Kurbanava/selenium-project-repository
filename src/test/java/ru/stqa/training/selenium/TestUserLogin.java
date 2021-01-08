package ru.stqa.training.selenium;

import org.junit.Test;
import pages.CreateAccountPage;
import pages.LitecartMain;

public class TestUserLogin  extends TestBase {


    @Test
    public void testNewUserCreation() throws InterruptedException {
        //openLitecart
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();

        //click 'New customers click here' to open create Account Page
       CreateAccountPage createAccountPage = litecartMain.openCreateAccountLink();

       //add random email
        createAccountPage.enterEmail();

        //fill in required fields
        createAccountPage.fillInName();
        createAccountPage.fillInAddress();
        createAccountPage.fillInPhone();
        createAccountPage.fillInPassword();
        createAccountPage.confirmPassword();

        //click Create Account
        createAccountPage.clickCreateAccount();

        //log out
       createAccountPage.logOut();


       //log in
        createAccountPage.enterEmail();
        createAccountPage.fillInPassword();
        createAccountPage.logIn();


  }











}
