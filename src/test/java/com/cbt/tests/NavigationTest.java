package com.cbt.tests;


import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class NavigationTest {

    public static void main(String[] args) {

        //1. Create class NavigationTests under tests package.
        //2. Automate the provided test case using 3 different browsers.
//        3. Create a separate test method for each browser.
//                a. If you are using Windows, create test methods for Chrome, Firefox, Edge.
//                b. If you are using Windows,create test methods for Chrome,Firefox, Safari.
//        4. Each test should close the browser after completion.
//        5. Test methods must use the utilities.
//        6. Run all three test methods from the main method.


        String [] browsers = {"chrome", "firefox"};

        for (String eachBrowser : browsers) {

            WebDriver driver = BrowserFactory.getDriver(eachBrowser);
            BrowserFactory.setupDriver(driver, 10);

            //1. Open browser
            //2. Go to website https://google.com/
            driver.get("https://google.com");

            //3. Save the title in a string variable
            String googleTitle = driver.getTitle();

            //4. Go to https://etsy.com/
            driver.get("https://etsy.com/");

            //5. Save the title in a string variable
            String etsyTitle = driver.getTitle();

            //6. Navigate back to previous page
            driver.navigate().back();

            //7. Verify that title is same is in step 3
            BrowserFactory.verifyEquals(driver.getTitle(), "god of war XD");

            //8. Navigate forward to previous page
            driver.navigate().forward();

            //9. Verify that title is same is in step 5
            BrowserFactory.verifyEquals(driver.getTitle(), etsyTitle);

            driver.close();


        }







    }

}
