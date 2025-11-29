package hw6.taxes;

public class TaxSystem {

    private String name;

    public TaxSystem(String name) {
        this.name = name;
    }

    public int calcTaxFor(int debit, int credit) {
        return 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
