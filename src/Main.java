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
        int[] numbers = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("До: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 1;
            } else {
                numbers[i] = 0;
            }

        }
        System.out.print("После: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        //11.
        int[] numbersnew = new int[100];
        for (int i = 0; i < 100; i++) {
            numbersnew[i] = i + 1;
        }
        System.out.println("Результат:");
        for (int i = 0; i < 100; i++) {
            System.out.print(numbersnew[i] + " ");
        }
        System.out.println();

        //12.
        int[] numbersThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        System.out.println("До:");
        for (int i = 0; i < numbersThree.length; i++) {
            System.out.print(numbersThree[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < numbersThree.length; i++) {
            if (numbersThree[i] < 6) {
                numbersThree[i] = numbersThree[i] * 2;
            }
        }

        System.out.println("После:");
        for (int i = 0; i < numbersThree.length; i++) {
            System.out.print(numbersThree[i] + " ");
        }
        System.out.println();


        //13.
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

        //14.
        int len = 4;
        int initialValue = 18;
        int[] array = createArray(len, initialValue);

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

    //10.1 в 10.
    //11.1 в 11.
    //12.1 в 12.
    //13.1 в 13
    //14.1
    public static int[] createArray(int len, int initialValue) {
        int[] arrayTwo = new int[len];
        for (int i = 0; i < len; i++) {
            arrayTwo[i] = initialValue;
        }
        return arrayTwo;
    }


}


