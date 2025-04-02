public class Main {
    public static void main(String[] args) {
        //1.
        printThreeWords();
        //2.
        checkSumSign();
        //3.
        printColor();
        //4.
        compareNumbers();
        //5.
        System.out.println(sumAB(10, -69));
        //6.
        numberOne(65);
        //7.
        System.out.println(numberTwo(-9));
        //8.
        stringAndNumber("Шла Саша по шоссе... ", 6);
        //9.
        System.out.println(leapYear(1984));
        //10.
        int[] array10 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("До:");
        System.out.println(arrayToString(array10));
        System.out.println("После:");
        System.out.println(arrayToString(invertArray(array10)));
        //11.
        System.out.println("100 чисел:");
        System.out.println(convertArrayToString(fillArrayWithNumbers()));
        //12.
        int[] array12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("До:");
        System.out.println(arrayToString(array12));
        System.out.println("После:");
        System.out.println(arrayToString(processArray(array12)));

        //13
        int n = 4;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //14
        int len = 4;
        int initialValue = 18;
        int[] array = createArray(len, initialValue);

        System.out.print("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    //1.1.
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    //2.1.
    public static void checkSumSign() {
        int a = 105;
        int b = 54;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3.1.
    public static void printColor() {
        int value = 122;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    //4.1
    public static void compareNumbers() {
        int a = 19;
        int b = 8;
        if (a >= b) {
            System.out.println("а >= b");
        } else {
            System.out.println("а < b");
        }
    }

    //5.1.
    public static boolean sumAB(int num1, int num2) {
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }

    //6.1.
    public static void numberOne(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    //7.1.
    public static boolean numberTwo(int number7) {
        return number7 < 0;
    }

    //8.1
    public static void stringAndNumber(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    //9.1
    public static boolean leapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    //10.1
    public static int[] invertArray(int[] inputArray) {
        int[] result = new int[inputArray.length];
        for (int i = 0; i < inputArray.length; i++) {
            result[i] = inputArray[i] == 0 ? 1 : 0;
        }
        return result;
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int value : array) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }

    //11.1
    public static int[] fillArrayWithNumbers() {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }

    public static String convertArrayToString(int[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            // Добавляем пробел, если не последний элемент
            if (i < array.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }


    //12.1
    public static int[] processArray(int[] arr) {
        int[] result = arr.clone();
        for (int i = 0; i < result.length; i++) {
            if (result[i] < 6) {
                result[i] *= 2;
            }
        }
        return result;
    }

    //14.1
    public static int[] createArray(int len, int initialValue) {
        int[] arrayTwo = new int[len];
        for (int i = 0; i < len; i++) {
            arrayTwo[i] = initialValue;
        }
        return arrayTwo;
    }
}
