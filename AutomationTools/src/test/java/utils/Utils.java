package utils;

public class Utils {

    public static String formatPrice(String price){
        int priceLength = price.length();
        if (priceLength > 3) {
            price = price.substring(0, priceLength - 3) + " " +
                    price.substring(priceLength - 3, priceLength);
        }
        return price + "₴";
    }

}
