package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import pages.LitecartMain;
import pages.ProductPage;

import java.text.NumberFormat;
import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestProducts extends TestBase{


    public boolean isGrey(String color){
        Color rgbaColor = Color.fromString(color);
        String rgba = rgbaColor.asRgba();
        String[] value = rgba.replace("rgba(", "").replace(" ", "").replace(")", "").split(",");
        System.out.println("R" + value[0]);
        System.out.println("G" + value[1]);
        System.out.println("B" + value[2]);


        return ( Integer.valueOf(value[0]) == Integer.valueOf(value[1]) && Integer.valueOf(value[1]) == Integer.valueOf(value[2]));

    }



    public boolean isRed (String color){
        Color rgbaColor = Color.fromString(color);
        String rgba = rgbaColor.asRgba();
        String[] value = rgba.replace("rgba(", "").replace(" ", "").replace(")", "").split(",");
        System.out.println("R" + value[0]);
        System.out.println("G" + value[1]);
        System.out.println("B" + value[2]);


        return ( Integer.valueOf(value[1]) == 0 && Integer.valueOf(value[2]) == 0 );

    }



@Test
public void checkCampaignsProductTitle(){
    //get the titles text on the main page and on the product page and compare
    LitecartMain litecartMain = new LitecartMain(driver);
    litecartMain.openLitecart();
     String mainPageProductTitle= litecartMain.getCampaignsProductName();
    ProductPage productPage = litecartMain.openCampaignsProduct();
    String ProductPageProductTitle= productPage.getTitle();
   assertEquals(mainPageProductTitle,ProductPageProductTitle);

}


    @Test
    public void checkCampaignsProductPrices(){
        //get the prices on the main page and on the product page and compare
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();
        String MPProductRegularPrice= litecartMain.getProductRegularPrice();
        String MPProductCampaignsPrice= litecartMain.getProductCampaignsPrice();
        ProductPage productPage = litecartMain.openCampaignsProduct();
        String PPProductRegularPrice= productPage.getProductRegularPrice();
        String PProductCampaignsPrice= productPage.getProductCampaignsPrice();
        assertEquals(MPProductRegularPrice,PPProductRegularPrice);
        assertEquals(MPProductCampaignsPrice,PProductCampaignsPrice);

    }




    @Test
    //get the price on the main page and check styles
    public void checkRegularPriceStylesMP()  {
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();
        assertTrue(isGrey(litecartMain.getProductRegularPriceColor()));
        assertEquals( "line-through solid rgb(119, 119, 119)",litecartMain.getProductRegularPriceTextDecor());

    }


    @Test
    //get the price on the main page and check styles
    public void checkCampaignsPriceStylesMP() {
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();
        assertTrue(isRed(litecartMain.getProductCampaignsPriceColor()));
        assertEquals( "none solid rgb(204, 0, 0)",litecartMain.getProductCampaignsPriceTextDecor());

    }


    @Test
    //get the price on the product page and check styles
    public void checkRegularPriceStylesPP() {
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();
        ProductPage productPage = litecartMain.openCampaignsProduct();
        assertTrue(isGrey(productPage.getProductRegularPriceColor()));
        assertEquals( "none solid rgb(204, 0, 0)",productPage.getProductCampaignsPriceStyles());

    }


    @Test
    //get the price on the product page and check styles
    public void checkCampaignsPriceStylesPP() {
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();
        ProductPage productPage = litecartMain.openCampaignsProduct();
       assertTrue(isRed(productPage.getProductCampaignsPriceColor()));
        assertEquals( "none solid rgb(204, 0, 0)",productPage.getProductCampaignsPriceStyles());

    }









    @Test
    //get the Price Size on the main page and check
    public void checkPricesSizeMP() throws ParseException {
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();

        boolean isLess= litecartMain.getProductRegularPriceSize() < litecartMain.getProductCampaignsPriceSize();

        assertTrue(isLess);

    }


    @Test
    //get the Price Size on the product page and check
    public void checkPricesSizePP() throws ParseException {
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();
        ProductPage productPage = litecartMain.openCampaignsProduct();

        boolean isLess= productPage.getProductRegularPriceSize() < productPage.getProductCampaignsPriceSize();

        assertTrue(isLess);

    }







}
