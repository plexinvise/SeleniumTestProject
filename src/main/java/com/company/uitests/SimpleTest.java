package com.company.uitests;

import com.company.common.BaseTest;
import com.company.common.SuiteListener;
import com.company.pageObjects.MainTestPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by plexinvise on 2/23/18.
 */
public class SimpleTest extends BaseTest {

    private WebDriver driver;
    private MainTestPage mainTestPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp () {
        driver = SuiteListener.getDriver();
        mainTestPage = PageFactory.initElements(driver, MainTestPage.class);
    }

    @Test(groups = {"All","Smoke"})
    public void simpleTest ()  {

        Assert.assertTrue(waitForElementPresent(mainTestPage.getAd()), "Ad is not appeared");
        if (mainTestPage.getAd().isDisplayed()) {
            Assert.assertTrue(waitForElementPresent(mainTestPage.getAdCloseBtn()), "AdClose button is not appeared");
            mainTestPage.getAdCloseBtn().click();
        }
    }


}
