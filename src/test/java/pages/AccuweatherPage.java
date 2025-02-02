package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ITextBox;
import constants.LocatorConstants;
import org.openqa.selenium.By;
import aquality.selenium.forms.Form;

public class AccuweatherPage extends Form {

    private final IElementFactory elementFactory = AqualityServices.getElementFactory();

    private final By POLICY_BUTTON = By.xpath(String.format(LocatorConstants.DIV_CLASS_XPATH, "banner-button policy-accept"));
    private final By SEARCH_FIELD = By.xpath(String.format(LocatorConstants.CLASS_XPATH, "search-input"));
    private final By RESULT_CONTAINER = By.xpath(String.format(LocatorConstants.DIV_CLASS_XPATH, "results-container"));
    private final By HEADER = By.xpath(String.format(LocatorConstants.CLASS_XPATH, "header-loc"));
    private final By FIRST_RESULT = By.xpath(String.format(LocatorConstants.CLASS_XPATH, "search-bar-result__name"));

    private final IButton clickPolicyButton = elementFactory.getButton(POLICY_BUTTON, "Policy");
    private final ITextBox textField = elementFactory.getTextBox(SEARCH_FIELD, "Search field");
    private final ITextBox resultContainer = elementFactory.getTextBox(RESULT_CONTAINER, "Result container");
    private final ITextBox firstResult = elementFactory.getTextBox(FIRST_RESULT, "First result");
    private final ITextBox header = elementFactory.getTextBox(HEADER, "Header result");

    public AccuweatherPage() {
        super(By.xpath(String.format(LocatorConstants.CLASS_XPATH, "accuweather")), "Main Page");
    }

    public void consentDataUser() { clickPolicyButton.click(); }

    public void inputSearch(String place) { textField.clearAndType(place); }

    public boolean isResultContainerExist() {
        return resultContainer.state().isExist();
    }

    public void clickFirstSearchResult(){ firstResult.click(); }

    public boolean matchSearchHeader(String search){ return header.getText().contains(search); }

}