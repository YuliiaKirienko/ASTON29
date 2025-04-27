import org.example.ArithmeticOperations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.AssertJUnit.assertEquals;

class ArithmeticOperationsTest {
    @DisplayName("Сложение")
    @Test
    void testAddition() {
        assertEquals(15, ArithmeticOperations.calculate(10, 5, "+"));
    }

    @DisplayName("Вычитание")
    @Test
    void testSubtraction() {
        assertEquals(5, ArithmeticOperations.calculate(10, 5, "-"));
    }

    @DisplayName("Умножение")
    @Test
    void testMultiplication() {
        assertEquals(50, ArithmeticOperations.calculate(10, 5, "*"));
    }

    @DisplayName("Деление")
    @Test
    void testDivision() {
        assertEquals(2, ArithmeticOperations.calculate(10, 5, "/"));
    }

    @DisplayName("Деление на 0")
    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class,
                () -> ArithmeticOperations.calculate(10, 0, "/"));
    }

    @DisplayName("Недопустимая операция")
    @Test
    void testInvalidOperation() {
        assertThrows(IllegalArgumentException.class,
                () -> ArithmeticOperations.calculate(10, 5, "%"));
    }
}