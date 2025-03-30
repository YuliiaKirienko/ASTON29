// задача 1.
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        LocalDate productionDate = LocalDate.of(2024, 10, 16);
        Product product1 = new Product("Наушники", productionDate, "Dexp", "Китай", 3000.00, false);


        System.out.println("Информация о продукте:");
        product1.printProductInfo();
        System.out.println();

    }
}
