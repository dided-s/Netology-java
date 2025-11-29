package hw6.deals;

public class Sale extends Deal {

    private String productName;
    private static final String PATTERN = "Продажа '%s' на %d руб.";

    public Sale(String productName, int price) {
        super(PATTERN.formatted(productName, price), 0, price);
        this.productName = productName;
    }
}
