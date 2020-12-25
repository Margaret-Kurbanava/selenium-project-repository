package ru.stqa.training.selenium;

import org.junit.Test;
import pages.LitecartMain;

public class TestLitecartMain extends TestBase{

    @Test
    public void checkStickersPresence(){
        LitecartMain litecartMain = new LitecartMain(driver);
        litecartMain.openLitecart();
        litecartMain.checkStickers();
    }


}
