public class Main {
    p public static void main(String[] args) {

        Dog dog1 = new Dog("Пылесос");
        Dog dog2 = new Dog("Гвоздик");
        Cat cat1 = new Cat("Веник");
        Cat cat2 = new Cat("Бублик");
        Cat cat3 = new Cat("Керасин");
        Cat cat4 = new Cat("Шерлок");

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
    public static void checkSumSign() {
        int a = 105;
        int b = 54;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else  {
            System.out.println("Сумма отрицательная");
        }
    }

    //3.1.
    public static void printColor() {
        int value = 122;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else if (value > 100) {
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
    public static boolean SumAB() {
        int a = 4;
        int b = 11;
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }
    //6.1.
    public static void NumberOne() {
        int number = - 25;
        if (number >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }
    }
//7.1.
    public static boolean NumberTwo() {
        int number = 16;
        if (number < 0) {
            System.out.println("true");
            return true;
        } else {
            System.out.println("false");
            return false;
        }
    }

    //8.1
    public static void StringAndNumber() {
        String str = "Мама мыла пилораму ";
        int n = 3;
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }
    //9.1
    public static boolean LeapYear() {
        int year = 1984;
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            System.out.println (year + "- високосный год");
            return true;
        }
        System.out.println (year + "- НЕ високосный год");
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


