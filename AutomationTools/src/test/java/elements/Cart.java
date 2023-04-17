package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Cart {

    private final SelenideElement goodTitle = $x("//a[@class='cart-product__title']");
    private final SelenideElement goodPrice = $x("//p[contains(@class,'cart-product__price')]");
    private final SelenideElement goodsCount = $x("//input[@data-testid='cart-counter-input']");
    private final SelenideElement sumPrice = $x("//div[@class='cart-receipt__sum-price']/span[1]");
    private final SelenideElement addOneMoreGood = $x("//button[contains(@class, 'cart-counter__button')][2]");
    private final SelenideElement subtractOneGood = $x("//button[contains(@class, 'cart-counter__button')][1]");
    private final SelenideElement goodActionButton = $x("//button[@id='cartProductActions0']");
    private final SelenideElement deleteGoodButton = $x("//button[contains(text(), ' Видалити')]");
    private final SelenideElement emptyChart = $x("//div[contains(@class, 'cart-dummy')]");
}
