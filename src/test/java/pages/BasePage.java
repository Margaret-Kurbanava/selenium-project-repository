package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class BasePage {



    public String generateRandomEmail(){

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(9000);

        String randomEmail = "testUser"+randomInt+"@gmail.com";

        return randomEmail;
    }









}
