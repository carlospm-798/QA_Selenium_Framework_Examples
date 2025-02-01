package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import constants.MainPageNavigation;
import org.testng.Assert;
import pages.BasicAuthPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.SettingsTestData;

public class BasicAuthTest extends BaseTest {
    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @BeforeMethod
    public void auth() {
        browser.network().addBasicAuthentication(
                SettingsTestData.getEnvData().getDomain(),
                SettingsTestData.getUserData().getUsername(),
                SettingsTestData.getUserData().getPassword());
    }

    @Test
    public void basicAuthTest() {
        mainPage.clickNavigationLink(MainPageNavigation.BASIC_AUTH);
        Assert.assertTrue(basicAuthPage.isSuccessMsgDisplayed(),
                "Success message was no displayed");
    }
}