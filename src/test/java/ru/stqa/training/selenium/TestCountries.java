package ru.stqa.training.selenium;

import org.junit.Test;
import pages.AdminLoginPage;
import pages.CountriesPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestCountries extends TestBase{


    @Test
    public void checkCountriesOrder(){

        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.loginToAdmin();

        CountriesPage countriesPage = new CountriesPage(driver);
        countriesPage.openCountriesPage();
       // System.out.println(countriesPage.getCountries());
       // System.out.println(countriesPage.checkSorting());
        assertTrue(countriesPage.checkSorting());


}


    @Test
    public void checkZonesOrder() throws InterruptedException {

        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.loginToAdmin();

        CountriesPage countriesPage = new CountriesPage(driver);
        countriesPage.openCountriesPage();
       countriesPage.checkZones();

    }






}