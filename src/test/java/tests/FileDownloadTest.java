package tests;

import constants.MainPageNavigation;
import org.testng.Assert;
import pages.FileDownloadPage;
import utils.FileUtils;
import utils.SettingsTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static io.qameta.allure.Allure.step;
import java.io.File;

public class FileDownloadTest extends BaseTest {
    private final FileDownloadPage fileDownloadPage = new FileDownloadPage();
    private final String fileName = SettingsTestData.getFileData().getDownloadFile();       // Working
    private final String filePath = SettingsTestData.RESOURCES_PATH + fileName;
    private final File downloadedFile = new File(filePath);


    @Test(enabled = true)
    public void fileDownloadTest() {
        step("Clicking file download");
        mainPage.clickNavigationLink(MainPageNavigation.FILE_DOWNLOAD);
        Assert.assertTrue(fileDownloadPage.isFileDownloadLinkDisplayed(fileName), "File is not displayed");
        step("Clicking the download file option");
        fileDownloadPage.clickFileDownloadLink(fileName);
        Assert.assertTrue(FileUtils.isFileExist(downloadedFile),
                "File is not downloaded");
    }

    @AfterMethod
    public void deleteFile() {
        step("Deleting the file");
        FileUtils.deleteFileIfExist(downloadedFile);
    }
}