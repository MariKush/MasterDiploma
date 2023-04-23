package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.elements.CartElement;
import pages.elements.HeaderElement;
import pages.elements.SearchResultsPage;


import static org.assertj.core.api.Assertions.assertThat;

public class CartSteps {
    String firstGoodsTitleInCatalog;
    Integer firstGoodsPriceInCatalog;
    Integer secondGoodsPriceInCatalog;

    SearchResultsPage searchResultsPage = new SearchResultsPage();
    HeaderElement headerElement = new HeaderElement();
    CartElement cartElement = new CartElement();

    @And("^I click add to cart button for the (\\d) good$")
    public void lickAddToCartButtonForGoodByIndex(Integer index) {
        searchResultsPage.getAddToCartButton(index - 1).click();
    }

    @Then("^I verify that cart header counter equals (.*)$")
    public void checkCartHeaderCounter(Integer count) {
        assertThat(headerElement.getCartCounter().getText()).isEqualTo(count.toString());
    }

    @And("^I store first goods title in catalog$")
    public void storeFirstGoodsTitleInCatalog() {
        firstGoodsTitleInCatalog = searchResultsPage.getGoodsTitles().get(0);
    }

    @And("^I store first goods price in catalog$")
    public void storeFirstGoodsPriceInCatalog() {
        firstGoodsPriceInCatalog = searchResultsPage.getGoodsPrices().get(0);
    }

    @And("^I open cart using header$")
    public void openCartUsingHeader() {
        headerElement.getCartButton().click();
    }

    @Then("^I verify that goods title in the cart equals to title in the catalog$")
    public void assertGoodsTitle() {
        assertThat(cartElement.getGoodTitle()).isEqualTo(firstGoodsTitleInCatalog);
    }

    @And("^I increment goods count in the cart$")
    public void incrementGoodsCountInTheCart() {
        cartElement.getAddOneMoreGood().click();
    }

    @Then("^I verify sum goods price in the cart with (.*) the same goods$")
    public void assertSumGoodsPriceForSomeCountOfTheSameGoodsInTheCart(int count) {
        String expectedPrice = firstGoodsPriceInCatalog * count  + "₴";
        int expectedPriceLength = expectedPrice.length();
        if (expectedPriceLength > 4) {
            expectedPrice = expectedPrice.substring(0, expectedPriceLength - 4) + " " +
                    expectedPrice.substring(expectedPriceLength - 4, expectedPriceLength);
        }
        assertThat(cartElement.getGoodPrice()).isEqualTo(expectedPrice);
    }

    @And("^I decrement goods count in the cart$")
    public void decrementGoodsCountInTheCart() {
        cartElement.getSubtractOneGood().click();
    }

    @And("^I store second goods price in catalog$")
    public void storeSecondGoodsPriceInCatalog() {
        secondGoodsPriceInCatalog = searchResultsPage.getGoodsPrices().get(1);
    }

    @Then("^I verify sum goods price in the cart with two different goods$")
    public void assertSumGoodsPriceForTwoDifferentInTheCart() {
        assertThat(cartElement.getSumPrice()).isEqualTo(firstGoodsPriceInCatalog + secondGoodsPriceInCatalog + "");
    }

    @And("^I open goods actions tab and choose delete button$")
    public void openGoodsActionsTabAndChooseDeleteButton() {
        cartElement.getGoodActionButton().click();
        cartElement.getDeleteGoodButton().click();
    }

    @Then("^I verify that empty cart icon present$")
    public void verifyThatEmptyCartIconPresent() {
        cartElement.emptyChartVisible();
    }

}
