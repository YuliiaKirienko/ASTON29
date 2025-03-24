import java.util.Arrays;
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
        System.out.println(isSumBetween10And20(4, 10));
        //6.
        checkNumber(50);
        //7.
        System.out.println(isNegative(13));  // false
        //8.
        printStringNTimes("Ученье - свет! ", 3);
        //9.
        int year = 1984;
        boolean isLeapYear = isLeapYear(year);
        System.out.println(year + " - високосный год: " + isLeapYear);
        //10.
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Original array: " + Arrays.toString(binaryArray));
        invertArray(binaryArray);
        System.out.println("Inverted array: " + Arrays.toString(binaryArray));
        //11.
        int[] hundredArray = new int[100];
        fillArray(hundredArray);
        System.out.println("Array filled with 1 to 100: " + Arrays.toString(hundredArray));
        //12.
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Original array: " + Arrays.toString(array));
        multiplyLessThan6(array);
        System.out.println("Modified array: " + Arrays.toString(array));
        //13.
        int[][] squareArray = new int[5][5];
        fillDiagonal(squareArray);
        for (int i = 0; i < squareArray.length; i++) {
            for (int j = 0; j < squareArray[i].length; j++) {
                System.out.print(squareArray[i][j] + " ");
            }
            System.out.println();
        }
        //14.
        int len = 4;
        int initialValue = 18;
        int[] myArray = createInitializedArray(len, initialValue);

        System.out.println("Initialized array: " + Arrays.toString(myArray));


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
        int b = -6;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //3.1.
    public static void printColor() {
        int value = 13;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
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
    public static boolean isSumBetween10And20(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    //6.1.
    public static void checkNumber(int number) {
        if (number >= 0) {
            System.out.println("Число " + number + " положительное");
        } else {
            System.out.println("Число " + number + " отрицательное");
        }
    }
//7.1.
    public static boolean isNegative(int number) {
        return number < 0;
    }

    //8.1
    public static void printStringNTimes(String str, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }
    //9.1
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            }
            return true;
        }
        return false;
    }

    //10.1

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
    }

    //11.1
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }

    //12.1
    public static void multiplyLessThan6(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2; // Multiply by 2 if less than 6
            }
        }
    }

    //13.1
    public static void fillDiagonal(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1; // Fill diagonal elements with 1
        }
    }

    //14.1
    public static int[] createInitializedArray(int len, int initialValue) {
        int[] array = new int[len]; // Create an array of length 'len'
        for (int i = 0; i < len; i++) {
            array[i] = initialValue; // Set each element to 'initialValue'
        }
        return array;
    }


}


