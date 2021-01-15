package ru.stqa.training.selenium;

import org.junit.Test;
import pages.CheckoutPage;
import pages.LitecartMain;
import pages.ProductPage;

public class TestCartUpdate extends TestBase{


    @Test
    public void testCartUpdate() throws InterruptedException {
        //open Litecart
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();

        //open first product
        ProductPage productPage = litecartMain.openFirstProduct();

        //add 3 products to the cart
        for (int i = 0; i < 3; i++) {
            productPage.addToCart();
        }

        //open a cart
        CheckoutPage checkoutPage= productPage.clickCheckout();

        //remove all products
        for (int i = 0; i < 3; i++) {
        checkoutPage.removeProduct();
        }
      

    }





}
