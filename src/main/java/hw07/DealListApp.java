package hw07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealListApp {

    private List<String> deals;
    private Scanner scanner;

    public DealListApp() {
        this.deals = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        DealListApp app = new DealListApp();

        while (true) {
            printCommands();

            System.out.print("Введите номер команды: ");
            int command = Integer.parseInt(app.scanner.nextLine());
            System.out.println("Ваш выбор: " + command);

            switch (command) {
                case 0: {
                    app.endApplication();
                    return;
                }
                case 1: {
                    app.addDeal();
                    break;
                }
                case 2: {
                    app.printDeals();
                    break;
                }
                case 3: {
                    app.removeDealNumber();
                    break;
                }
                case 4: {
                    app.removeDealString();
                    break;
                }
                case 5: {
                    app.removeDealKeyword();
                    break;
                }
                default: {
                    System.out.println("Вы ввели неправильный номер команды");
                    break;
                }
            }
        }
    }

    public static void printCommands() {
        System.out.println(
                """
                        
                        Выберите операцию:
                        0. Выход из программы
                        1. Добавить дело
                        2. Показать дела
                        3. Удалить дело по номеру
                        4. Удалить дело по названию
                        5. Удалить дело по ключевому слову
                        
                        """);
    }

    public void addDeal() {
        System.out.print("Введите название задачи: ");
        String deal = scanner.nextLine();
        this.deals.add(deal);
        System.out.println("Добавлено!");
        printDeals();
    }

    public void removeDealNumber() {
        System.out.print("Введите номер для удаления: ");
        int dealNumber = Integer.parseInt(scanner.nextLine());

        if (dealNumber <= 0 || dealNumber > deals.size()) {
            System.out.println("Вы ввели некорректный номер");
            return;
        }
        int dealIndex = dealNumber - 1;
        deals.remove(dealIndex);
        System.out.println("Удалено!");
        printDeals();
    }

    public void removeDealString() {
        System.out.print("Введите задачу для удаления: ");
        String deal = scanner.nextLine();

        for (int i = 0; i < deals.size(); i++) {
            if (deal.equals(deals.get(i))) {
                deals.remove(i);
                System.out.println("Удалено!");
                printDeals();
                return;
            }
        }
        System.out.printf("В списке дел нет дела с текстом '%s'\n", deal);
        printDeals();
    }

    public void removeDealKeyword() {
        System.out.print("Введите ключевое слово для удаления: ");
        String keyword = scanner.nextLine();

        int removedDealsCount = 0;

        int i = 0;
        while (i < deals.size()) {
            if (deals.get(i).contains(keyword)) {
                removedDealsCount++;
                System.out.printf("Удалено: %d. %s\n", i + 1 + removedDealsCount, deals.get(i));
                deals.remove(i);
            } else {
                i++;
            }
        }

        System.out.println("Количество удаленных дел: " + removedDealsCount);
        printDeals();
    }

    public void printDeals() {
        if (deals.isEmpty()) {
            System.out.println("Ваш список дел пуст.");
            return;
        }
        System.out.println("Ваш список дел:");
        for (int i = 0; i < deals.size(); i++) {
            System.out.println((i + 1) + ". " + deals.get(i));
        }
    }

    public void endApplication() {
        System.out.println("Выход из приложения");
    }
}
