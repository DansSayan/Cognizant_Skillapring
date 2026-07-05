package com.example;

public class Operations {
    public float Division(int a, int b) {
        if (b == 0) 
            throw new IllegalArgumentException("Division by zero is not allowed.");
        return (float) a / b;
    }
    public long Factorial(int n) {
        if (n < 0) 
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        long result = 1;
        for (int i=1 ; i<=n; i++) 
            result *= i;
        return result;
    }
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i=2 ; i<=Math.sqrt(number) ; i++)
            if (number%i == 0)
                return false;
        return true;
    }
}