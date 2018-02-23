package com.company.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by plexinvise on 2/23/18.
 */
public class MainTestPage {

    // PageObject to find elements through Selenium PageFactory

    @FindBy(how = How.CLASS_NAME, using = "tynt-ad-frame")
    WebElement ad;

    @FindBy(how = How.CLASS_NAME, using = "tynt-close-btn")
    WebElement adCloseBtn;

    public WebElement getAd () {
        return this.ad;
    }

    public WebElement getAdCloseBtn () {
        return this.adCloseBtn;
    }

}
