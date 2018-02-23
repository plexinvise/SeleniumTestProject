package com.company.common;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by plexinvise on 2/23/18.
 */
public class SuiteListener implements ISuiteListener {

    private SeleniumDriverManager driverManager;
    private static WebDriver driver;


    @BeforeSuite(alwaysRun = true)
    public void onStart (ISuite suite) {

        // Reading browser parameter from TestNgConfig to run for different browsers
        // Helpful in setting automation runs through jenkins etc.
        String browser = suite.getXmlSuite().getAllParameters().get("browser");
        driverManager =
                new SeleniumDriverManager(suite.getXmlSuite().getAllParameters().get("url"));

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = driverManager.initChromeDriver();
        }

        if (browser.equalsIgnoreCase("FireFox")) {
            driver = driverManager.initFirefoxDriver();
        }

    }


    // Closing driver after suite completed
    @AfterSuite(alwaysRun = true)
    public void onFinish (ISuite suite) {
        if (driver!=null) {
            driverManager.driverClose(driver);
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
