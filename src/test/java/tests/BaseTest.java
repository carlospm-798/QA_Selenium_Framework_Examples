package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public abstract class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void setup() {
        browser = AqualityServices.getBrowser();
        browser.maximize();
        browser.goTo(SettingsTestData.getEnvData().getHost());
    }

    @AfterMethod
    public void teardown() {
        browser.quit();
    }
}