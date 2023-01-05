package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class MyListsPageObject extends MainPageObject {

    protected static String
        FOLDER_BY_NAME_TPL,
        SYNC_WINDOW_CLOSE_BUTTON,
        DELETE_ARTICLE_BUTTON,
        ARTICLE_BY_TITLE_TPL;

    private static String getFolderXPathByName(String name_of_folder){
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSavedArticleXPathByTitle(String article_title){
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject (AppiumDriver driver)
    {
        super(driver);
    }

    public void openFolderByName(String name_of_folder)
    {
        String folder_name_xpath = getFolderXPathByName(name_of_folder);
        this.waitForElementAndClick(
                folder_name_xpath,
                "Cannot open '" + name_of_folder + "' list",
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title){
        String article_title_xpath = getSavedArticleXPathByTitle(article_title);
        this.waitForElementPresent(
                article_title_xpath,
                "Cannot find saved article by title " + article_title,
                15
        );
    }

    public void waitForArticleToDisappearByTitle(String article_title){
        String article_title_xpath = getSavedArticleXPathByTitle(article_title);
        this.waitForElementNotPresent(
                article_title_xpath,
                "Saved article still present with title after deleting " + article_title,
                15
        );
    }

    public void swipeByArticleToDelete(String article_title){
        this.waitForArticleToAppearByTitle(article_title);
        String article_title_xpath = getSavedArticleXPathByTitle(article_title);
        this.swipeElementToLeft(
                article_title_xpath,
                "Cannot find saved article"
        );
        this.waitForArticleToDisappearByTitle(article_title);
    }

    public void openArticleByTitle(String article_title) {
        String article_title_xpath = getSavedArticleXPathByTitle(article_title);
        this.waitForElementAndClick(
                article_title_xpath,
                "Cannot find article " + article_title + " in the current list",
                5
        );
    }

    public void closeSyncWindow() {
        this.waitForElementAndClick(SYNC_WINDOW_CLOSE_BUTTON, "Cannot find close button for sync window", 5);
    }

    public void clickOnDeleteArticleButton() {
        this.waitForElementAndClick(DELETE_ARTICLE_BUTTON, "Cannot find delete article from my list button", 5);
    }
}
