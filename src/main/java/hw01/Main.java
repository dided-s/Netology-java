package hw01;

public class Main {
    public static void main(String[] args) {
        printFullName("Saranova Gilyana");

        int income = 44000;
        int spending = 30000;
        System.out.println(calculateProfit(income, spending));
    }

    private static void printFullName(String fullName) {
        System.out.println(fullName);
    }

    private static int calculateProfit(int income, int spending) {
        return income - spending;
    }
}
