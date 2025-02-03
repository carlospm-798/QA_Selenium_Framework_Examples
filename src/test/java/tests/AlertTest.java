package tests;

import aquality.selenium.browser.AlertActions;
import pages.JavaScriptAlertsPage;
import constants.MainPageNavigation;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import static aquality.selenium.browser.AqualityServices.getBrowser;

public class AlertTest extends BaseTest {
    private final JavaScriptAlertsPage javaScriptAlertsPage = new JavaScriptAlertsPage();

    @Test
    public void alertTest() {
        step("Click navigation link");
        mainPage.clickNavigationLink(MainPageNavigation.JAVASCRIPT_ALERT);
        step("Click for JavaScript alert button");
        javaScriptAlertsPage.clickForJsAlertBtn();
        step("Accept alert");
        getBrowser().handleAlert(AlertActions.ACCEPT);
        // Assert does not require step
        Assert.assertTrue(javaScriptAlertsPage.isSuccessLabelDisplayed(), "Success msg is not displayed");
    }
}