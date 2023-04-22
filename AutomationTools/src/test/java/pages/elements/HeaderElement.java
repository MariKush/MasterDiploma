package pages.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class HeaderElement {

    private final SelenideElement searchField = $x("//input[@name='search']");
    private final SelenideElement cartCounter = $x("//span[contains(@class, 'badge--green')]");
    private final SelenideElement cartButton = $x("//button[contains(@class, 'header__button--active')]");

    public SelenideElement getSearchField() {
        return searchField.shouldBe(visible);
    }

    public SelenideElement getCartCounter() {
        return cartCounter.shouldBe(visible);
    }

    public SelenideElement getCartButton() {
        return cartButton.shouldBe(visible);
    }

}
