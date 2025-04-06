// задание 1.

import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {

        Product product1 = new Product("Наушники", LocalDate.of(2024, 10, 16), "Dexp", "Китай", 3000.00, false);

        System.out.println("Информация о продукте:");
        product1.printProductInfo();
        System.out.println();

        // задание 2.
        Product[] productsArray = new Product[5];

        productsArray[0] = new Product("Очки", LocalDate.of(2021, 10, 11), "NeoLook", "Южная Корея", 11000.00, true);
        productsArray[1] = new Product("Блокнот", LocalDate.of(2022, 11, 12), "ООО Хатбер-М", "Россия", 100.00, false);
        productsArray[2] = new Product("Телефон", LocalDate.of(2023, 12, 13), "HUAWEI", "Китай", 15000.00, true);
        productsArray[3] = new Product("Ноутбук", LocalDate.of(2024, 02, 14), "Lenovo", "Китай", 30000.00, true);
        productsArray[4] = new Product("Книга", LocalDate.of(2025, 01, 15), "ООО Азбука+", "Россия", 99.00, false);

        //задание 3.

        Park myPark = new Park("Наш парк");
        Park.Attraction ferrisWheel = myPark.new Attraction("Колесо обозрения", "10:00 - 22:00", 500);
        Park.Attraction bungee = myPark.new Attraction("Тарзанка", "10:00 - 22:00", 1000);
        myPark.addAttraction(ferrisWheel);
        myPark.addAttraction(bungee);
        myPark.printAllAttractions();
    }
}
