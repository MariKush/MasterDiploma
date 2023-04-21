package pages.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.util.stream.Collectors.toList;

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
    private final SelenideElement priceFilterOkButton = $x("//button[contains(@class, ' slider-filter')]");
    private final String filterCheckBox = "//a[@class='tile-filter__link' and contains(text(),'%s')]";


    public List<String> getGoodsTitles(){
        return goodsTitles.texts();
    }

    public void catalogEmptyVisible(){
        catalogEmpty.shouldBe(visible);
    }

    public SelenideElement getMinPriceInput(){
        return minPriceInput.shouldBe(visible);
    }

    public SelenideElement getMaxPriceInput(){
        return maxPriceInput.shouldBe(visible);
    }

    public SelenideElement getPriceFilterOkButton(){
        return priceFilterOkButton.shouldBe(visible);
    }

    public List<Integer> getGoodsPrices() {
        goodsPrices.get(0).shouldBe(visible);
        return goodsPrices.asDynamicIterable().stream()
                .map(SelenideElement :: getText)
                .map(text -> text.replaceAll("\\s+", ""))
                .map(Integer :: parseInt)
                .collect(toList());
    }

}