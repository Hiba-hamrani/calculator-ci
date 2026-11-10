package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("2 + 2 = 4")
    void addTwoPositiveNumbers() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Subtraction can return a negative result")
    void subtractReturnsNegative() {
        assertEquals(-3, calculator.subtract(2, 5));
    }

    @Test
    @DisplayName("Multiplication by zero returns zero")
    void multiplyByZero() {
        assertEquals(0, calculator.multiply(7, 0));
    }

    @Test
    @DisplayName("10 / 4 = 2.5")
    void divideReturnsDecimal() {
        assertEquals(2.5, calculator.divide(10, 4), 0.0001);
    }

    @Test
    @DisplayName("Division by zero throws ArithmeticException")
    void divideByZeroThrows() {
        ArithmeticException ex = assertThrows(ArithmeticException.class,
                () -> calculator.divide(5, 0));
        assertEquals("Division by zero is not allowed", ex.getMessage());
    }
}
