package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Appium";
        FOOTER_ELEMENT = "xpath://XCUIElementTypeStaticText[@name='View article in browser']";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Search";
        MY_LIST_BY_TITLE_TPL = "xpath://*[@text='{LIST_TITLE}']";
        TAP_TO_GO_BACK_POPOVER = "id:Tap to go back";
        W_BUTTON = "id:W";
    }

    public iOSArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
