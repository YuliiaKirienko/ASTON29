public class Main {
    public static void main(String[] args) {
        // 1. Корректные массивы
        String[][] correctArray1 = {
                {"50", "51", "52", "53"},
                {"54", "55", "56", "57"},
                {"58", "59", "60", "61"},
                {"62", "63", "64", "65"}
        };


        // 2. Массивы неправильного размера
        String[][] wrongSizeArray1 = new String[4][3];  // 4x3
        String[][] wrongSizeArray2 = new String[5][5];  // 5x5

        // 3. Массивы с некорректными данными
        String[][] wrongDataArray1 = {
                {"50", "51", "52", "53"},
                {"54", "55", "XX", "57"},  // Символ
                {"58", "59", "60", "61"},
                {"62", "63", "64", "65"}
        };

        String[][] wrongDataArray2 = {
                {"50", "51", "52", "53"},
                {"54", "55", "5.6", "57"},  // Дробное число
                {"58", "59", "60", "61"},
                {"62", "63", "64", "65"}
        };

        String[][] wrongDataArray3 = {
                {"50", "51", "", "53"},    // Пустая строка
                {"54", "55", "56", "57"},
                {"58", "59", "60", "61"},
                {"62", "63", "64", "65"}
        };



        System.out.println("Тестирование метода");


        System.out.println("\n Корректные массивы");
        testArray(correctArray1, "Корректный массив 1 (50-65)");

        System.out.println("\n Массивы неправильного размера");
        testArray(wrongSizeArray1, "Массив 4x3");
        testArray(wrongSizeArray2, "Массив 5x5");

        System.out.println("\n Массивы с некорректными данными");
        testArray(wrongDataArray1, "Массив с символом 'X'");
        testArray(wrongDataArray2, "Массив с дробным числом");
        testArray(wrongDataArray3, "Массив с пустой строкой");
    }

    private static void testArray(String[][] array, String description) {
        System.out.println("\nТест: " + description);
        try {
            int sum = ArrayUtils.sumStringArray(array);
            System.out.println("Сумма частей: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
    }
}
