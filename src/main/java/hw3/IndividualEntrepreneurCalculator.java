package hw3;

import java.util.Scanner;

public class IndividualEntrepreneurCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int income = 0;    // доходы
        int expense = 0;    // расходы

        while (true) {
            System.out.print("""
                    Выберите операцию и введите её номер:
                    1. Добавить новый доход
                    2. Добавить новый расход
                    3. Выбрать систему налогообложения
                    """);
            String inputLine = scanner.nextLine();
            if (inputLine.equals("end")) {
                break;
            }
            int commandNumber = Integer.parseInt(inputLine);

            switch (commandNumber) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int newIncome = Integer.parseInt(scanner.nextLine());
                    income += newIncome;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    int newExpense = Integer.parseInt(scanner.nextLine());
                    expense += newExpense;
                    break;
                case 3:
                    int simplifiedTaxIncome = calculateSimplifiedTaxIncome(income);
                    int simplifiedTaxIncomeMinusExpenses = calculateSimplifiedTaxIncomeMinusExpenses(income, expense);

                    if (simplifiedTaxIncome == simplifiedTaxIncomeMinusExpenses) {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    } else if (simplifiedTaxIncome > simplifiedTaxIncomeMinusExpenses) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + simplifiedTaxIncomeMinusExpenses + " рублей");
                        System.out.println("Налог на другой системе: " + simplifiedTaxIncome + " рублей");
                        System.out.println("Экономия: " + (simplifiedTaxIncome - simplifiedTaxIncomeMinusExpenses) + " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + simplifiedTaxIncome + " рублей");
                        System.out.println("Налог на другой системе: " + simplifiedTaxIncomeMinusExpenses + " рублей");
                        System.out.println("Экономия: " + (simplifiedTaxIncomeMinusExpenses - simplifiedTaxIncome) + " рублей");
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    public static int calculateSimplifiedTaxIncome(int income) {
        int tax = income * 6 / 100;
        return tax > 0 ? tax : 0;
    }

    public static int calculateSimplifiedTaxIncomeMinusExpenses(int income, int expense) {
        int tax = (income - expense) * 15 / 100;

        return tax > 0 ? tax : 0;
    }
}
