package pages.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchResultsPage {

    //Products items
    private final ElementsCollection goodsTitles = $$x("//span[@class='goods-tile__title']");
    private final ElementsCollection goodsPrices =
            $$x("//div[@class='goods-tile ng-star-inserted']//span[@class='goods-tile__price-value']");
    private final ElementsCollection addToCartButtons =
            $$x("//button[contains(@class, 'goods-tile__buy-button')]");

    private final SelenideElement catalogEmpty = $x("//div[@class='catalog-empty']");

    //Sorting
    private final SelenideElement selectSortOption = $x("//select[contains(@class, 'select-css')]");
    private final SelenideElement cheapFirstOption = $x("//option[contains(@value, 'cheap')]");
    private final SelenideElement expensiveFirstOption = $x("//option[contains(@value, 'expensive')]");

    //Filtering
    private final SelenideElement minPriceInput = $x("//input[@formcontrolname='min']");
    private final SelenideElement maxPriceInput = $x("//input[@formcontrolname='max']");
    private final SelenideElement priceFilterOKButton = $x("//button[contains(@class, ' slider-filter')]");
    private final String filterCheckBox = "//a[@class='tile-filter__link' and contains(text(),'%s')]";

}