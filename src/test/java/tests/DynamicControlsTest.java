package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.DynamicControlsPage;
import org.testng.annotations.Test;

import java.util.UUID;

public class DynamicControlsTest extends BaseTest {
    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private final String randomText = UUID.randomUUID().toString();

    @Test
    public void dynamicControlsTest() {
        mainPage.clickNavigationLink(MainPageNavigation.DYNAMIC_CONTROLS);
        dynamicControlsPage.clickEnableBtn();
        Assert.assertTrue(dynamicControlsPage.isInputEnabled(), "Input is not enabled");
        dynamicControlsPage.inputText(randomText);
        Assert.assertEquals(dynamicControlsPage.getInputTextValue(), randomText,
                "Text is not displayed");
    }
}