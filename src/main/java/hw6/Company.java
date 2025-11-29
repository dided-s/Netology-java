package hw6;

import hw6.deals.Deal;
import hw6.taxes.TaxSystem;

public class Company {
    private String title;
    private int debit;
    private int credit;
    private TaxSystem taxSystem;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
        this.debit = 0;
        this.credit = 0;
    }

    public int applyDeals(Deal[] deals) {
        System.out.printf("Компания %s совершает сделки:\n", title);
        for (int i = 0; i < deals.length; i++) {
            System.out.print(i + 1 + ": ");
            shiftMoney(deals[i].getDebitChange());
            shiftMoney(-1 * deals[i].getCreditChange());
            System.out.println(deals[i].getComment());
        }

        int diff = debit - credit;
        System.out.printf("Разница между доходами(%d) и расходами(%d) = %d.\n", debit, credit, diff);
        payTaxes();
        return diff;
    }

    public void payTaxes() {
        int tax = taxSystem.calcTaxFor(debit, credit);
        System.out.printf("Компания %s уплатила налог(%s) в размере: %d руб.\n", title, taxSystem, tax);
        debit = 0;
        credit = 0;
    }

    public void shiftMoney(int amount) {
        if (amount > 0) {
            debit += amount;
        } else if (amount < 0) {
            credit += Math.abs(amount);
        }
    }

    public void setTaxSystem(TaxSystem newTaxSystem) {
        System.out.printf("Замена для компании %s налоговой системы '%s' на '%s'\n", title, this.taxSystem, newTaxSystem);
        this.taxSystem = newTaxSystem;
    }
}
