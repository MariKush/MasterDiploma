package pages.elements;

import com.codeborne.selenide.SelenideElement;

import java.beans.PropertyEditor;

import static com.codeborne.selenide.Selenide.$x;

public class HeaderElement {

    private final SelenideElement searchField = $x("//search");
    private final SelenideElement cartCounter = $x("//span[contains(@class, 'badge--green')]");
    private final SelenideElement cartButton = $x("//button[contains(@class, 'header__button--active')]");

    public SelenideElement getSearchField() {
        return searchField;
    }

}
