import org.example.NumberComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberComparatorTest {

    @DisplayName("Равные числа")
    @Test
    void testEqualNumbers() {
        assertEquals("Числа равны", NumberComparator.compare(5, 5));
        assertEquals("Числа равны", NumberComparator.compare(0, 0));
        assertEquals("Числа равны", NumberComparator.compare(-3, -3));
    }

    @DisplayName("Первое число больше")
    @Test
    void testFirstGreater() {
        assertEquals("Первое число больше", NumberComparator.compare(10, 5));
        assertEquals("Первое число больше", NumberComparator.compare(-1, -5));
        assertEquals("Первое число больше", NumberComparator.compare(1, -1));
    }

    @DisplayName("Второе число больше")
    @Test
    void testSecondGreater() {
        assertEquals("Второе число больше", NumberComparator.compare(5, 10));
        assertEquals("Второе число больше", NumberComparator.compare(-5, -1));
        assertEquals("Второе число больше", NumberComparator.compare(-1, 1));
    }


}