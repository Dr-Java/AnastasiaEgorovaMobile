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
        getDriver().get(GOOGLE_URL);

        new WebDriverWait(getDriver(), 100)
            .until(wd -> ((JavascriptExecutor) wd)
                .executeScript(READY_STATE)
                .equals(COMPLETE));


        assertEquals( getDriver().getTitle(), PAGE_TITLE,
            "Incorrect page title");

        WebPageObject webPageObject = new WebPageObject(getDriver());

        WebElement searchField = webPageObject.getSearchField();
        searchField.click();
        searchField.sendKeys(QUERY);

        List<WebElement> searchSuggestionsList = webPageObject.getSearchSuggestionsList();
        searchSuggestionsList.get(0).click();
        new WebDriverWait(getDriver(), 10);

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
