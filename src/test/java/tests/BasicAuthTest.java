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
import static io.qameta.allure.Allure.step;

public class BasicAuthTest extends BaseTest {
    private final BasicAuthPage basicAuthPage = new BasicAuthPage();

    @BeforeMethod
    public void auth() {
        step("Getting domain, username and password data");
        browser.network().addBasicAuthentication(
                SettingsTestData.getEnvData().getDomain(),
                SettingsTestData.getUserData().getUsername(),
                SettingsTestData.getUserData().getPassword());
    }

    @Test(enabled = false)
    public void basicAuthTest() {
        step("Clicking on Basic Auth option");
        mainPage.clickNavigationLink(MainPageNavigation.BASIC_AUTH);
        Assert.assertTrue(basicAuthPage.isSuccessMsgDisplayed(),
                "Success message was no displayed");
    }
}