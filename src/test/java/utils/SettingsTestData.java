package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import com.google.gson.Gson;
import models.*;
import lombok.experimental.UtilityClass;
import pages.AccuweatherPage;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    public final String RESOURCES_PATH = "src/test/resources/";
    public final String TEST_DATA_PATH = RESOURCES_PATH + "testdata/";
    private final String ENVIRONMENT_PATH = RESOURCES_PATH + "environment/";
    private final String UI_USER_FILE_PATH = TEST_DATA_PATH + "uiData.json";
    private final String UI_PASSWORD_PATH = TEST_DATA_PATH + "uiPasswordData.json";
    private final String ACCUWEATHER_DATA_PATH = TEST_DATA_PATH + "weatherData.json";
    private final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");
    private final Gson GSON = new Gson();

    public EnvData getEnvData() {
        String envConfigPath = "%s%s.json".formatted(ENVIRONMENT_PATH, getCurrentEnvironment());
        return deserializeJson(envConfigPath, EnvData.class);
    }

    public AccuweatherData getAccuweatherData() { return deserializeJson(ACCUWEATHER_DATA_PATH, AccuweatherData.class); }

    public UIData getUIUserData() { return deserializeJson(UI_USER_FILE_PATH, UIData.class); }

    public UIPasswordData getUIPassword() { return deserializeJson(UI_PASSWORD_PATH, UIPasswordData.class); }

    private String getCurrentEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }

    private <T> T deserializeJson(String filePath, Class<T> tClass) {
        try {
            return GSON.fromJson(new FileReader(filePath), tClass);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error("Settings file %s not found or incorrect. Error msg: %s".formatted(filePath, e));
            throw new RuntimeException(e);
        }
    }
}