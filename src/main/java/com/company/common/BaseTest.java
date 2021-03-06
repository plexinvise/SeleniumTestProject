package com.company.common;

import org.openqa.selenium.WebElement;

/**
 * Created by plexinvise on 2/23/18.
 */
public class BaseTest {

    int pollingTime = 10;

    // Also possible to implement WebElement interface and add method waitFor.
    // It will extend the functionality of WebElement and make it more convenient in usage
    public boolean waitForElementPresent (WebElement element) {
        while (pollingTime>=0) {
        if (element.isDisplayed()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return true;
        }
        pollingTime--;
        }
        return false;
    }

}
