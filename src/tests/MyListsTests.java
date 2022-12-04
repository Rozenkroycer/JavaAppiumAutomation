package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    @Test
    public void testSaveFirstArticleToMyList(){

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "Learning programming";
        ArticlePageObject.addArticleToMyList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
        MyListPageObject.openFolderByName(name_of_folder);
        MyListPageObject.swipeByArticleToDelete(article_title);
    }

    @Test
    public void testSaveTwoArticles() {
        SearchPageObject SearchObject = new SearchPageObject(driver);
        SearchObject.initSearchInput();
        String search_line = "Java";
        SearchObject.typeSearchLine(search_line);
        String substring = "Java (programming language)";
        SearchObject.clickByArticleWithSubstring(substring);

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
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

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListPageObject = new MyListsPageObject(driver);
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
