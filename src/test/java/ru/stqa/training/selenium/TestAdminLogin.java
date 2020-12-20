package ru.stqa.training.selenium;

import org.junit.Test;
import pages.AdminLoginPage;

public class TestAdminLogin extends TestBase{

    @Test
    public void testAdminLogin (){

        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.openAdminLoginPage();
        adminLoginPage.enterUsename("admin");
        adminLoginPage.enterPassword("admin");
        adminLoginPage.clickLogin();

    }




}
