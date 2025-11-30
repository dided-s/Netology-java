package hw08;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>() {{
            put(new Address("Россия", "Москва"), 500);
            put(new Address("Россия", "Саратов"), 1000);
            put(new Address("Белоруссия", "Минск"), 1200);
            put(new Address("Белоруссия", "Гомель"), 1500);
            put(new Address("Казахстан", "Нурсултан"), 2000);
            put(new Address("Китай", "Пекин"), 2500);
        }};

        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueCountries = new HashSet<>();
        int totalCost = 0;

        while (true) {

            System.out.println("Заполнение нового заказа.");
            System.out.print("Введите страну [или end]: ");
            String country = scanner.nextLine();
            if (country.equals("end")) break;

            System.out.print("Введите город [или end]: ");
            String city = scanner.nextLine();
            if (city.equals("end")) break;

            System.out.print("Введите вес (кг) [или end]: ");
            String weightString = scanner.nextLine();
            if (weightString.equals("end")) break;
            int weight = Integer.parseInt(weightString);

            Address currentAddress = new Address(country, city);

            if (costPerAddress.containsKey(currentAddress)) {
                int cost = weight * costPerAddress.get(currentAddress);
                System.out.println("Стоимость доставки составит: " + cost + " руб.");
                totalCost += cost;
                System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
                uniqueCountries.add(country);
                System.out.println("Были оформлены доставки в " + uniqueCountries.size() + " стран");
                System.out.println(uniqueCountries);
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
            System.out.println();
        }
    }
}
