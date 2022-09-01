package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver getDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("safari") && System.getProperty("OS.name").contains("mac")) {
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        } else if (browser.equalsIgnoreCase("edge") && System.getProperty("OS.name").contains("windows")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else {
            return null;
        }

    }


    public static void setupDriver(WebDriver driver, int second) {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);


    }


    public static void verifyEquals( String actual, String expected){

        if(actual.equals(expected)){
            System.out.println("PASS");
        } else {
            System.out.println("FAILED =(");
        }

    }

}
