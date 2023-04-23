package pages.elements;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class CartElement {

    private final SelenideElement goodTitle = $x("//a[@class='cart-product__title']");
    private final SelenideElement goodPrice = $x("//p[contains(@class,'cart-product__price')]");
    private final SelenideElement sumPrice = $x("//div[@class='cart-receipt__sum-price']/span[1]");
    private final SelenideElement addOneMoreGood = $x("//button[contains(@class, 'cart-counter__button')][2]");
    private final SelenideElement subtractOneGood = $x("//button[contains(@class, 'cart-counter__button')][1]");
    private final SelenideElement goodActionButton = $x("//button[@id='cartProductActions0']");
    private final SelenideElement deleteGoodButton = $x("//button[contains(text(), ' Видалити')]");
    private final SelenideElement emptyChart = $x("//div[contains(@class, 'cart-dummy')]");

    public String getGoodTitle() {
        return goodTitle.shouldBe(visible).getText();
    }

    public String getGoodPrice() {
        Selenide.sleep(500);
        return goodPrice.shouldBe(visible).getText();
    }

    public String getSumPrice() {
        Selenide.sleep(500);
        return sumPrice.shouldBe(visible).getText();
    }

    public SelenideElement getAddOneMoreGood() {
        return addOneMoreGood.shouldBe(visible);
    }

    public SelenideElement getSubtractOneGood() {
        return subtractOneGood.shouldBe(visible);
    }

    public SelenideElement getGoodActionButton() {
        return goodActionButton.shouldBe(visible);
    }

    public SelenideElement getDeleteGoodButton() {
        return deleteGoodButton.shouldBe(visible);
    }

    public void emptyChartVisible() {
         emptyChart.shouldBe(visible);
    }

}
