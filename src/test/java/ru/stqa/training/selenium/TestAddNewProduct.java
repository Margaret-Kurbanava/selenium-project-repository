package ru.stqa.training.selenium;

import org.junit.Test;
import pages.AdminLoginPage;
import pages.AdminPageMain;
import pages.CatalogPage;

import static org.junit.Assert.assertTrue;

public class TestAddNewProduct extends TestBase {


    @Test
    public void checkNewProductAdding() throws InterruptedException {

        //login to Admin
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        AdminPageMain adminPageMain = adminLoginPage.loginToAdmin();

        //go to Catalog
        adminPageMain.clickMenuLink("catalog");

        //click AddNewProduct
        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.clickAddNewProduct();

        //add data and save
        catalogPage.fillGeneralInfo();
        catalogPage.fillInformation();
        catalogPage.fillPrices();
        catalogPage.clickSave();


        //check if product id added
        assertTrue(catalogPage.isProductDisplayed());

    }


}
