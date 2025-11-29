package hw6;

import hw6.deals.Deal;
import hw6.deals.Expenditure;
import hw6.deals.Sale;
import hw6.taxes.SimplifiedIncomeMinusCreditTaxSystem;
import hw6.taxes.SimplifiedTaxSystem;

public class Main {
    public static void main(String[] args) {
        SimplifiedTaxSystem simplifiedTaxSystem = new SimplifiedTaxSystem();
        SimplifiedIncomeMinusCreditTaxSystem simplifiedIncomeMinusCreditTaxSystem = new SimplifiedIncomeMinusCreditTaxSystem();

        Company dogCompany = new Company("ООО 'Щенята'", simplifiedTaxSystem);
        Company catCompany = new Company("ООО 'Котята'", simplifiedIncomeMinusCreditTaxSystem);

        dogCompany.shiftMoney(100);
        dogCompany.shiftMoney(-50);
        dogCompany.payTaxes();

        catCompany.shiftMoney(100);
        catCompany.shiftMoney(-50);
        catCompany.payTaxes();

        System.out.println("------- 1 -------");
        Deal[] catDeals = {
                new Expenditure("Курица", 1000),
                new Expenditure("Говядина", 500),
                new Sale("Вискас", 2000),
                new Sale("Китикэт", 1000)
        };
        catCompany.applyDeals(catDeals);
        System.out.println("------- 2 -------");
        catCompany.setTaxSystem(simplifiedTaxSystem);
        catCompany.applyDeals(catDeals);

        System.out.println("------- 3 -------");
        Deal[] dogDeals = {
                new Expenditure("Курица", 1000),
                new Expenditure("Говядина", 500),
                new Sale("Педигри", 500),
                new Sale("Чаппи", 200)
        };
        dogCompany.applyDeals(dogDeals);
        System.out.println("------- 4 -------");
        dogCompany.setTaxSystem(simplifiedIncomeMinusCreditTaxSystem);
        dogCompany.applyDeals(dogDeals);
    }
}
