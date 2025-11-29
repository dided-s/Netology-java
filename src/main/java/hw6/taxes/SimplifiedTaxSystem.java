package hw6.taxes;

public class SimplifiedTaxSystem extends TaxSystem {

    public SimplifiedTaxSystem() {
        super("УСН доходы");
    }

    public int calcTaxFor(int debit, int credit) {
        int tax = debit * 6 / 100;
        return Math.max(tax, 0);
    }
}
