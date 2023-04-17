package elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderElement {

    private final SelenideElement searchField = $x("//search");
    private final SelenideElement cartCounter = $x("//span[contains(@class, 'badge--green')]");
    private final SelenideElement cartButton = $x("//button[contains(@class, 'header__button--active')]");

}
