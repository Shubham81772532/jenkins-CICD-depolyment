package com.example;

public class SmartCalculator {

    // Power (a^b)
    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    // Factorial (5! = 120)
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative not allowed");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Prime check
    public boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Average of array
    public double average(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Empty array");
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        return (double) sum / numbers.length;
    }
}