package tests;

import pages.DataTablesPage;
import constants.MainPageNavigation;
import utils.SettingsTestData;
import utils.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;

public class DataTableTests extends BaseTest {
    private final DataTablesPage dataTablesPage = new DataTablesPage();

    @Test
    public void dataTableTest() {
        step("Clicking on sortable data table");
        mainPage.clickNavigationLink(MainPageNavigation.SORTABLE_DATA_TABLES);
        step("Getting the data values");
        Double actualSum = 0.0;
        for (String due : dataTablesPage.getFirstDueList()) {
            actualSum += StringUtils.getDoubleFromString(due);
        }
        Assert.assertEquals(actualSum, SettingsTestData.getDataTableData().getExpectedDueSum(), "Sum is not correct");
    }
}