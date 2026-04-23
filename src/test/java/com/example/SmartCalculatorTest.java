package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmartCalculatorTest {

    SmartCalculator calc = new SmartCalculator();

    @Test
    void testPower() {
        assertEquals(8.0, calc.power(2, 3));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calc.factorial(5));
    }

    @Test
    void testPrime() {
        assertTrue(calc.isPrime(7));
        assertFalse(calc.isPrime(4));
    }

    @Test
    void testAverage() {
        int[] nums = {2, 4, 6, 8};
        assertEquals(5.0, calc.average(nums));
    }
}