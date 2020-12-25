package ru.stqa.training.selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import pages.AdminLoginPage;
import pages.AdminPageMain;

public class TestAdminPage extends TestBase{

    @Test
    public  void testAdminLogin (){

        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.openAdminLoginPage();
        adminLoginPage.enterUsename("admin");
        adminLoginPage.enterPassword("admin");
        adminLoginPage.clickLogin();

    }


    @Test
    public void testAdminMenu(){

        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.openAdminLoginPage();
        adminLoginPage.enterUsename("admin");
        adminLoginPage.enterPassword("admin");
        adminLoginPage.clickLogin();
        AdminPageMain adminPageMain = new AdminPageMain(driver);
        adminPageMain.checkLinks();
    }






}
