package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    @Test
    public void testSaveFirstArticleToMyList() throws InterruptedException {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Appium");
        SearchPageObject.clickByArticleWithSubstring("Automation for Apps");

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();

        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.addArticleToMyList(name_of_folder);
        } else {
            ArticlePageObject.closeArticle();
            SearchPageObject.clickByArticleWithSubstring("Automation for Apps");
            ArticlePageObject.addArticleToMySaved();
        }

        if (Platform.getInstance().isAndroid()){
            ArticlePageObject.closeArticle();
        } else {
            ArticlePageObject.returnToMain();
        }

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()){
            MyListPageObject.openFolderByName(name_of_folder);
        }

        if (Platform.getInstance().isIOS()){
            MyListPageObject.closeSyncWindow();
        }

        MyListPageObject.swipeByArticleToDelete(article_title);

        if (Platform.getInstance().isIOS()){
            MyListPageObject.clickOnDeleteArticleButton();
        }
    }

    @Test
    public void testSaveTwoArticles() throws InterruptedException {
        SearchPageObject SearchObject = SearchPageObjectFactory.get(driver);
        SearchObject.initSearchInput();
        String search_line = "Java";
        SearchObject.typeSearchLine(search_line);
        String substring = "Java (programming language)";
        SearchObject.clickByArticleWithSubstring(substring);

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        SearchObject.initSearchInput();
        String second_search_line = "Python";
        SearchObject.typeSearchLine(second_search_line);
        String second_substring = "Python (programming language)";
        SearchObject.clickByArticleWithSubstring(second_substring);

        String the_second_article_title_before_saving = ArticlePageObject.getArticleTitle();
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.addArticleToCurrentList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = MyListsPageObjectFactory.get(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(substring);
        MyListPageObject.waitForArticleToDisappearByTitle(substring);
        MyListPageObject.waitForArticleToAppearByTitle(second_substring);
        MyListPageObject.openArticleByTitle(second_substring);

        String the_second_article_title_after_saving = ArticlePageObject.getArticleTitle();

        assertEquals(
                "Article title have been changed after deleting the first article",
                the_second_article_title_before_saving,
                the_second_article_title_after_saving
        );
    }
}
