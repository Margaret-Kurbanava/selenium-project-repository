package pages;

import java.io.File;
import java.util.Random;

public class BasePage {



    public String generateRandomEmail(){

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(9000);

        String randomEmail = "testUser"+randomInt+"@gmail.com";

        return randomEmail;
    }



    public String generateRandomProductName(){

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(9000);
        return "Product"+randomInt;
    }



    public String getAbsolutePath(String path) {
        String absolute;
        {

            // try-catch block to handle exceptions


                // Create a file object
                File f = new File(path);

                // Get the absolute path of file f
               absolute = f.getAbsolutePath();

                // Display the file path of the file object
                // and also the file path of absolute file
                System.out.println("Original  path: "
                        + f.getPath());
                System.out.println("Absolute  path: "
                        + absolute);

        }


        return absolute;
    }

}
