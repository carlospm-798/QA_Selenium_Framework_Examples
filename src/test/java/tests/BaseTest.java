package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import pages.MainPage;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    protected final MainPage mainPage = new MainPage();
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