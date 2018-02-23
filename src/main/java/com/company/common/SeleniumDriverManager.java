package com.company.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by plexinvise on 2/23/18.
 */
public class SeleniumDriverManager {

    private String URL;

    public SeleniumDriverManager(String URL) {
        this.URL = URL;
    }

    public WebDriver initChromeDriver () {

        // Setting ChromeDriver location
        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    public WebDriver initFirefoxDriver () {

        // Setting GeckoDriver location
        System.setProperty("webdriver.gecko.driver", "geckodriver");

        WebDriver driver = new FirefoxDriver();
        driver.get(URL);
        return driver;
    }

    public void driverClose (WebDriver driver) {
        driver.close();
    }

}
