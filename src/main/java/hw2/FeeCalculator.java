package hw2;

import java.util.Scanner;

public class FeeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите цену товара (в руб.): ");
        int priceInRussianRubles = scanner.nextInt();

        System.out.print("Введите вес товара (в кг.): ");
        int weightInKg = scanner.nextInt();

        int russianRublesDuty = calculateDutyInRussianRubles(priceInRussianRubles, weightInKg);
        System.out.println("Размер пошлины (в руб.) составит: " + russianRublesDuty);

    }

    /**
     * Вычисляет пошлину
     *
     * @param priceInRussianRubles цена товара в рублях
     * @param weightInKg           вес товара в килограммах
     * @return возвращает пошлину в копейках
     */
    public static int calculateDutyInRussianRubles(int priceInRussianRubles, int weightInKg) {
        // 1 копейка за каждый рубль цены товара
        int dutyPriceInRussianKopec = priceInRussianRubles;

        // 100 рублей за каждый килограмм товара
        int dutyWeightInRussianKopec = weightInKg * 100 * 100;

        return (dutyPriceInRussianKopec + dutyWeightInRussianKopec) / 100;
    }
}
