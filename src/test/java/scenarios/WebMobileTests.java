package scenarios;

import static constants.WebMobileTestsConstants.*;
import static org.testng.Assert.*;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.WebPageObject;
import setup.BaseTest;

public class WebMobileTests extends BaseTest {

    @Test(groups = {"web"})
    public void testSuccessfulGoogleSearch() throws InterruptedException {

        //Open Google search page
        getDriver().get(GOOGLE_URL);

        new WebDriverWait(getDriver(), 100)
            .until(wd -> ((JavascriptExecutor) wd)
                .executeScript(READY_STATE)
                .equals(COMPLETE));

        //Check page title is correct
        assertEquals( getDriver().getTitle(), PAGE_TITLE,
            "Incorrect page title");

        WebPageObject webPageObject = new WebPageObject(getDriver());

        //Make a search using keyword 'EPAM'
        WebElement searchField = webPageObject.getSearchField();
        searchField.click();
        searchField.sendKeys(QUERY);

        //Make sure there are some relevant suggestions
        List<WebElement> searchSuggestionsList = webPageObject.getSearchSuggestionsList();
        assertTrue(searchSuggestionsList.size() > 0,
            "List of suggestions is empty");

        //Click on first suggestion
        searchSuggestionsList.get(0).click();
        new WebDriverWait(getDriver(), 10);

        //Make sure there are some relevant results
        List<WebElement> searchResults = webPageObject.getSearchResults();
        assertTrue(searchResults.size() > 0,
            "List of results is empty");

        /*
        getElement method doesn't work here

        WebElement searchField2 = getIPageObject().getElement("searchField");
        searchField2.click();
        searchField2.sendKeys(QUERY);

        List<WebElement> searchSuggestionsList2 = getIPageObject()
            .getElements("searchSuggestionsList");
        searchSuggestionsList2.get(0).click();
        new WebDriverWait(getDriver(), 10);

        assertTrue(getIPageObject().getElements("searchResults").size() > 0,
            "List of results is empty");
         */

        System.out.println("Android web test done");
    }
}
