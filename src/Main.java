public class Main {
    public static void main(String[] args) {
        //1.
        printThreeWords();
        //2.
        String result = checkSumSign();
        System.out.println(result);
        //3.
        String result3 = printColor();
        System.out.println(result3);
        //4.
        String result4 = compareNumbers();
        System.out.println(result4);
        //5.
        int a = 4;
        int b = 11;
        boolean result5 = SumAB(a, b);
        System.out.println(result5);
        //6.
        int number6 = -25;
        NumberOne(number6);
        //7.
        int number7 = 9;
        boolean result7 = NumberTwo(number7);
        System.out.println(result7);
        //8.
        String str = "Мама мыла пилораму";
        int n = 3;
        StringAndNumber(str, n);
        //9.
        int year = 1984;
        boolean result9 = LeapYear(year);
        System.out.println(result9);


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
        int n13 = 4;
        int[][] cvadrat = new int[n][n];
        for (int i = 0; i < n; i++) {
            cvadrat[i][i] = 1;
        }
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(cvadrat[row][col] + " ");
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
    public static String checkSumSign() {
        int a = 105;
        int b = 54;
        int sum = a + b;
        if (sum >= 0) {
            return "Сумма положительная";
        } else {
            return "Сумма отрицательная";
        }
    }

    //3.1.
    public static String printColor() {
        int value = 122;
        if (value <= 0) {
            return "Красный";
        } else if (value <= 100) {
            return "Желтый";
        } else {
            return "Зеленый";
        }
    }

    //4.1
    public static String compareNumbers() {
        int a = 19;
        int b = 8;
        if (a >= b) {
            return "а >= b";
        } else {
            return "а < b";
        }
    }

    //5.1.
    public static boolean SumAB(int num1, int num2) {
        int sum = num1 + num2;
        return sum >= 10 && sum <= 20;
    }

    //6.1.
    public static void NumberOne(int number) {
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }

    //7.1.
    public static boolean NumberTwo(int number7) {
        return number7 < 0;
    }

    //8.1
    public static void StringAndNumber(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    //9.1
    public static boolean LeapYear(int year) {
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
    //13.1 в 13.

    //14.1
    public static int[] createArray(int len, int initialValue) {
        int[] arrayTwo = new int[len];
        for (int i = 0; i < len; i++) {
            arrayTwo[i] = initialValue;
        }
        return arrayTwo;
    }


}


