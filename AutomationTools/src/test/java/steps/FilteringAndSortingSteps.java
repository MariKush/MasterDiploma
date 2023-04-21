package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.elements.SearchResultsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class FilteringAndSortingSteps {

    SearchResultsPage searchResultsPage = new SearchResultsPage();

    @And("^I set (.*) value in min cost field and press OK$")
    public void setValueInMinCostFieldAndPressEnter(String minCost) {
        searchResultsPage.getMinPriceInput().clear();
        searchResultsPage.getMinPriceInput().setValue(minCost);
        searchResultsPage.getPriceFilterOkButton().click();
    }

    @And("^I set (.*) value in max cost field and press OK$")
    public void setValueInMaxCostFieldAndPressEnter(String maxCost) {
        searchResultsPage.getMaxPriceInput().clear();
        searchResultsPage.getMaxPriceInput().setValue(maxCost);
        searchResultsPage.getPriceFilterOkButton().click();
    }

    @Then("^I verify that all prices greater than (.*)$")
    public void assetThatAllGoodsPricesGreaterThatValue(int cost) {
        searchResultsPage.getGoodsPrices()
                .forEach(price -> assertThat(price).isGreaterThanOrEqualTo(cost));
    }

    @Then("^I verify that all prices less than (.*)$")
    public void assetThatAllGoodsPricesLessThatValue(int cost) {
        searchResultsPage.getGoodsPrices()
                .forEach(price -> assertThat(price).isLessThanOrEqualTo(cost));
    }


    @And("^I choose (cheap|expensive) first sort option$")
    public void chooseSortOption(String sortingOption) {
        searchResultsPage.getSelectSortOption().click();
        searchResultsPage.getSortingOption(sortingOption).click();
    }


}
