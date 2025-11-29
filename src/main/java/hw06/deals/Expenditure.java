package hw06.deals;

public class Expenditure extends Deal {

    private String productName;
    private static final String PATTERN = "Покупка '%s' на %d руб.";

    public Expenditure(String productName, int price) {
        super(PATTERN.formatted(productName, price), price, 0);
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
