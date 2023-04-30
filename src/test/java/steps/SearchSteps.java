package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.elements.HeaderElement;
import pages.elements.SearchResultsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSteps {

    HeaderElement headerElement = new HeaderElement();
    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @And("^I set (.*) value in Search field and press Enter$")
    public void setValueInSearchFieldAndPressEnter(String searchWord) {
        headerElement.getSearchField().setValue(searchWord).pressEnter();
    }

    @Then("^I verify that search result contains (.*) word$")
    public void assetThatSearchResultsContainsSearchWord(String searchWord) {
        searchResultsPage.getGoodsTitles()
                .forEach(goodTitle -> assertThat(goodTitle).containsIgnoringCase(searchWord));
    }

    @Then("^I see catalog empty icon$")
    public void assetThatCatalogIsEmpty() {
        searchResultsPage.catalogEmptyVisible();
    }


}
