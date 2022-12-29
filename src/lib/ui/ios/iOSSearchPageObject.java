package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class iOSSearchPageObject extends SearchPageObject
{
    static {
        SEARCH_INIT_ELEMENT ="xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT ="xpath://XCUIElementTypeSearchField[@label='Search Wikipedia']";
        SEARCH_CANCEL_BUTTON ="xpath://XCUIElementTypeButton[@name='Cancel']";
        SEARCH_RESULT_BY_SUBSTRING_TPL ="xpath://XCUIElementTypeStaticText[contains(@name,'{SUBSTRING}')]";
        SEARCH_RESULT_ELEMENT ="xpath://XCUIElementTypeOther";
        SEARCH_EMPTY_RESULTS_LABEL ="xpath://XCUIElementTypeStaticText[@name='No results found']";
        SEARCH_LINE_PLACEHOLDER ="id:org.wikipedia:id/search_src_text"; // посмотреть как можно поменять (отдельного id для плейсхолдера нет)
    }

    public iOSSearchPageObject(AppiumDriver driver)
    {
        super(driver);
    }
}
