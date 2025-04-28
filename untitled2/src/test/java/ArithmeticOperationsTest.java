import org.example.ArithmeticOperations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.testng.AssertJUnit.assertEquals;

class ArithmeticOperationsTest {

    @ParameterizedTest(name = "Тест {index}: {0} {2} {1} = {3}")
    @CsvSource({
            // Положительные числа
            "5, 3, +, 8",
            "10, 4, -, 6",
            "7, 2, *, 14",
            "15, 3, /, 5",

            // Отрицательные числа
            "-5, -3, +, -8",
            "-10, 4, *, -40"
    })
    void testOperationsWithNegativeNumbers(int a, int b, String operation, int expected) {
        assertEquals(expected, ArithmeticOperations.calculate(a, b, operation));
    }
}