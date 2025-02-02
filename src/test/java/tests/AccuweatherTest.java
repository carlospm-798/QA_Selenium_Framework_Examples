package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.AccuweatherPage;
import utils.SettingsTestData;

public class AccuweatherTest extends BaseTest {

    AccuweatherPage accuweatherPage = new AccuweatherPage();

    @Test
    public void finalTask() {
        accuweatherPage.consentDataUser();
        accuweatherPage.inputSearch(SettingsTestData.getAccuweatherData().getPlace());
        Assert.assertTrue(accuweatherPage.isResultContainerExist(),
                "Result container does not exists");
        accuweatherPage.clickFirstSearchResult();
        Assert.assertTrue(accuweatherPage.matchSearchHeader(SettingsTestData.getAccuweatherData().getPlace()),
                "Result does not match with the search");
    }
}
