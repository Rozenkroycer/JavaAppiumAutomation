package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Appium";
        FOOTER_ELEMENT = "id:View page in browser";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later";
        CLOSE_ARTICLE_BUTTON = "id:Search";
        MY_LIST_BY_TITLE_TPL = "xpath://*[@text='{LIST_TITLE}']";
    }

    public iOSArticlePageObject (AppiumDriver driver)
    {
        super(driver);
    }
}
