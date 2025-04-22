public class Main {
    public static void main(String[] args) {
        // 1.Корректные массивы
        String[][] correctArray1 = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        // 2.Массивы неправильного размера
        String[][] wrongSizeArray1 = new String[3][4];  // 3x4
        String[][] wrongSizeArray2 = new String[4][5];  // 4x5

        // 3. Массивы с некорректными данными
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "X", "8"},  // Символ
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // 4. Проверка ArrayIndexOutOfBoundsException
        String[][] outOfBoundsArray = new String[4][];
        outOfBoundsArray[0] = new String[4];
        outOfBoundsArray[1] = new String[3];  // Неправильный размер строки
        outOfBoundsArray[2] = new String[4];
        outOfBoundsArray[3] = new String[4];

        // Тестирование
        System.out.println("Тестирование метода:");

        testArray(correctArray1, "Корректный массив");
        testArray(wrongSizeArray1, "Массив 3x4");
        testArray(wrongSizeArray2, "Массив 4x5");
        testArray(wrongDataArray, "Массив с некорректными данными");

        // Тест ArrayIndexOutOfBoundsException
        System.out.println("\nТест ArrayIndexOutOfBoundsException:");
        try {
            // Вызываем исключение
            String[][] testArray = new String[4][4];
            String value = testArray[4][0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }


    }

    private static void testArray(String[][] array, String description) {
        System.out.println("\nТест: " + description);
        try {
            int sum = ArrayUtils.sumStringArray(array);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }
    }
}
