package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.AccuweatherPage;
import utils.SettingsTestData;
import static io.qameta.allure.Allure.step;
public class AccuweatherTest extends BaseTest {

    AccuweatherPage accuweatherPage = new AccuweatherPage();

    @Test
    public void finalTask() {
        step("Consent the data user");
        accuweatherPage.consentDataUser();
        step("Input New York in the search");
        accuweatherPage.inputSearch(SettingsTestData.getAccuweatherData().getPlace());
        Assert.assertTrue(accuweatherPage.isResultContainerExist(),
                "Result container does not exists");
        step("Clicking the first result");
        accuweatherPage.clickFirstSearchResult();
        Assert.assertTrue(accuweatherPage.matchSearchHeader(SettingsTestData.getAccuweatherData().getPlace()),
                "Result does not match with the search");
    }
}