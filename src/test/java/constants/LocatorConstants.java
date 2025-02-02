package constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class LocatorConstants {
    public final String PRECISE_TEXT_XPATH = "//*[text()='%s']";
    public final String PARTICULAR_TEXT_XPATH = "//*[contains(text(),'%s')]";
    public final String CLASS_XPATH = "//*[@class='%s']";
    public final String DIV_CLASS_XPATH = "//div[@class='%s']";
}