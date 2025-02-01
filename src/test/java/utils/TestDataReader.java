package utils;

import models.*;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TestDataReader {
    public final String TEST_DATA_PATH = JsonReader.RESOURCES_PATH + "testdata/";
    private final String USER_FILE_PATH = TEST_DATA_PATH + "userData.json";
    private final String DATA_TABLE_FILE_PATH = TEST_DATA_PATH + "dataTableData.json";
    private final String FILE_DATA_PATH = TEST_DATA_PATH + "fileData.json";

    public UserData getUserData() {
        return JsonReader.deserializeJson(USER_FILE_PATH, UserData.class);
    }

    public DataTableData getDataTableData() {
        return JsonReader.deserializeJson(DATA_TABLE_FILE_PATH, DataTableData.class);
    }

    public FileData getFileData() {
        return JsonReader.deserializeJson(FILE_DATA_PATH, FileData.class);
    }
}
