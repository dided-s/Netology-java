package hw06.taxes;

public class SimplifiedIncomeMinusCreditTaxSystem extends TaxSystem {

    public SimplifiedIncomeMinusCreditTaxSystem() {
        super("УСН доходы минус расходы");
    }

    @Override
    public int calcTaxFor(int debit, int credit) {
        int tax = (debit - credit) * 15 / 100;
        return Math.max(tax, 0);
    }
}
