package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static io.qameta.allure.Allure.step;

public abstract class BaseTest {
    protected Browser browser;

    @BeforeMethod
    public void setup() {
        step("Open the browser");
        browser = AqualityServices.getBrowser();
        step("Maximize the browser window");
        browser.maximize();
        step("Go to start URL");
        browser.goTo(SettingsTestData.getEnvData().getHost());
        step("Wait for page to load");
        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void teardown() {
        step("Quiting the browser");
        browser.quit();
    }
}