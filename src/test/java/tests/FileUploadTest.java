package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.FileUploadPage;
import pages.UploadedFilePage;
import utils.SettingsTestData;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import java.io.File;

public class FileUploadTest extends BaseTest {

    private FileUploadPage fileUploadPage = new FileUploadPage();
    private UploadedFilePage uploadedFilePage = new UploadedFilePage();
    private final String FILE_NAME = SettingsTestData.getFileData().getUploadFile();
    private final String FILE_PATH = SettingsTestData.TEST_DATA_PATH + FILE_NAME;

    @Test
    public void fileUploadTest() {
        step("Clicking on file upload");
        mainPage.clickNavigationLink(MainPageNavigation.FILE_UPLOAD);
        step("Selecting the test file");
        fileUploadPage.uploadFile(new File(FILE_PATH).getAbsolutePath());
        step("Clicking submit button");
        fileUploadPage.clickSubmitBtn();
        Assert.assertEquals(uploadedFilePage.getUploadedFileName(), FILE_NAME,
                "File name is not correct or missed");
    }
}