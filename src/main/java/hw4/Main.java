package hw4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Author NikolaiGogol = new Author("Николай", "Гоголь", 8);

        // Урок про массивы я просмотрела
        Book[] books = {
                new Book("Нос", 1836, NikolaiGogol, 23),
                new Book("Ревизор", 1836, NikolaiGogol, 224),
                new Book("Тарас Бульба", 1835, NikolaiGogol, 320),
                new Book("Мертвые души", 1842, NikolaiGogol, 512),};

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("""
                    Выберите операцию и введите её номер:
                    1. Узнать: есть ли книга по ключевому слову. Мы выведем номера книг, которые совпадают по слову.
                    2. Узнать: большая ли книга по ее номеру.
                    3. Узнать: какая цена у книги по ее номеру.
                    
                    Наберите "end", чтобы закончить программу.
                    """);

            System.out.print("Введите номер операции: ");
            String inputLine = scanner.nextLine();
            if (inputLine.equals("end")) {
                break;
            }

            int commandNumber = Integer.parseInt(inputLine);

            switch (commandNumber) {
                case 1: {
                    System.out.print("Введите ключевое слово: ");
                    String word = scanner.nextLine();

                    int bookCount = 0;
                    for (int i = 0; i < books.length; i++) {
                        if (books[i].matches(word)) {
                            bookCount++;
                            System.out.println("Номер книги: " + i + ". " + books[i].getInfo());
                        }
                    }

                    if (bookCount == 0) {
                        System.out.println("Мы не нашли книги по ключевому слову");
                    }
                    System.out.println("_________________");

                    break;
                }
                case 2: {
                    System.out.print("Введите номер книги: ");
                    int bookNumber = Integer.parseInt(scanner.nextLine());

                    if (bookNumber >= 0 && bookNumber < books.length) {
                        System.out.println(books[bookNumber].getInfo());
                        if (books[bookNumber].isBig()) {
                            System.out.println("Данная книга является большой");
                        } else {
                            System.out.println("Данная книга является маленькой");
                        }
                    } else {
                        System.out.println("Книги с таким номером нет");
                    }
                    System.out.println("_________________");
                    break;
                }
                case 3: {
                    System.out.print("Введите номер книги: ");
                    int bookNumber = Integer.parseInt(scanner.nextLine());

                    if (bookNumber >= 0 && bookNumber < books.length) {
                        System.out.println(books[bookNumber].getInfo());
                        System.out.println("Цена книги: " + books[bookNumber].estimatePrice());
                    } else {
                        System.out.println("Книги с таким номером нет.");
                    }
                    System.out.println("_________________");
                    break;
                }
                default:
                    System.out.println("Такой операции нет");
                    System.out.println("_________________");
            }
        }
    }
}
