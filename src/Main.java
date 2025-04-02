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
        int[] myArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.print("До: ");
        for (int i = 0; i < myArray.length; i++) {
            System.out.print(myArray[i] + " ");
        }
        System.out.println();
        massiv10(myArray);
        //11.
        System.out.println("Результат: ");
        massiv11(100);
        //12.
        int[] muArray12 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("До:");
        for (int i = 0; i < muArray12.length; i++) {
            System.out.print(muArray12[i] + " ");
        }
        System.out.println();
        System.out.println("После: "); // Add this line
        massiv12(muArray12);
        //13
        massiv13();
        //14
        massiv14();
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
    public static void massiv10(int[] arr) {
        System.out.print("После: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] > 0) ? 0 : 1;
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //11.1
    public static void massiv11(int size) {
        int[] fillArr = new int[size];
        for (int i = 0; i < fillArr.length; i++) {
            fillArr[i] = i + 1;
            System.out.print(fillArr[i] + " ");
        }
    }

    //12.1
    public static void massiv12(int[] myArray12) {
        for (int i = 0; i < myArray12.length; i++) {
            if (myArray12[i] < 6) {
                myArray12[i] = myArray12[i] * 2;
            }
            System.out.print(myArray12[i] + " ");
        }
        System.out.println();
    }

    //13.1
    public static void massiv13() {
        int size = 5;
        int[][] squareArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            squareArray[i][i] = 1;
        }
        System.out.println("Квадрат: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(squareArray[i][j] + " ");
            }
            System.out.println();
        }
    }

    //14.1
    public static void massiv14() {
        int len = 4;
        int initialValue = 81;
        int[] array = createArray(len, initialValue);
        System.out.println("Массив: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        return array;
    }
}

