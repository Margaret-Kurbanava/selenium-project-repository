package ru.stqa.training.selenium;

import org.junit.Test;
import pages.AdminLoginPage;
import pages.CountriesPage;
import pages.GeoZonesPage;

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
        //login To Admin
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.loginToAdmin();

        //open Countries Page
        CountriesPage countriesPage = new CountriesPage(driver);
        countriesPage.openCountriesPage();

        //check zones sorting
        countriesPage.selectCountry("Canada");
        assertTrue(countriesPage.areZonesSorted());
        countriesPage.goBack();

        countriesPage.selectCountry("United States");
        assertTrue(countriesPage.areZonesSorted());
    }


    @Test
    public void checkGeoZones() throws InterruptedException {
        //login To Admin
        AdminLoginPage adminLoginPage = new AdminLoginPage(driver);
        adminLoginPage.loginToAdmin();

        //open geoZones Page
        GeoZonesPage geoZonesPage = new GeoZonesPage(driver);
        geoZonesPage.opengeozonesPage();

        //check zones sorting
        assertTrue(geoZonesPage.checkZonesSorting());
    }






}