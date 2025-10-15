package iw1;

import java.util.Scanner;

public class DataUtil {

    public static void main(String[] args) {
        //firstProject();
        secondProject();
    }

    public static void firstProject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Проверка количества дней в году");
        System.out.println("Введите год в формате yyyy");
        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        System.out.println("Количество дней " + getDaysNumberInYear(year));
    }

    public static void secondProject() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        while (true) {
            System.out.print("Введите год: ");
            int year = scanner.nextInt();

            System.out.print("Введите количество дней: ");
            int daysNumber = scanner.nextInt();

            int expectedDaysNumber = getDaysNumberInYear(year);

            if (expectedDaysNumber == daysNumber) {
                score++;
            } else {
                System.out.println("Неправильно! В этом году " + expectedDaysNumber + " дней!");
                break;
            }
        }
        System.out.println("Набрано очков: " + score);
    }

    public static int getDaysNumberInYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        } else return 365;
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }
}
