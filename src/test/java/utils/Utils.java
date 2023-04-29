package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class Utils {

    public static String formatPrice(String price){
        int priceLength = price.length();
        if (priceLength > 3) {
            price = price.substring(0, priceLength - 3) + " " +
                    price.substring(priceLength - 3, priceLength);
        }
        return price + "₴";
    }

    public static void jsClick(WebElement element){
        ((JavascriptExecutor) WebDriverRunner.getWebDriver())
                .executeScript("arguments[0].click()", element);
    }

}
