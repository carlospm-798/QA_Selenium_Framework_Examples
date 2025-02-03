package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.DynamicControlsPage;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import java.util.UUID;

public class DynamicControlsTest extends BaseTest {
    private final DynamicControlsPage dynamicControlsPage = new DynamicControlsPage();
    private final String randomText = UUID.randomUUID().toString();

    @Test
    public void dynamicControlsTest() {
        step("Clicking on dynamic controls");
        mainPage.clickNavigationLink(MainPageNavigation.DYNAMIC_CONTROLS);
        step("Clicking enable button");
        dynamicControlsPage.clickEnableBtn();
        Assert.assertTrue(dynamicControlsPage.isInputEnabled(), "Input is not enabled");
        step("Inserting random text");
        dynamicControlsPage.inputText(randomText);
        Assert.assertEquals(dynamicControlsPage.getInputTextValue(), randomText,
                "Text is not displayed");
    }
}