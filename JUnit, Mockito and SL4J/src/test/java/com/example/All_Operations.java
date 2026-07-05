package com.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class All_Operations {
    private Operations oper;

    @Before
    public void setUp() {
        oper = new Operations();
    }

    @Test
    public void testDivision_Success() {
        // Arrange
        int numerator = 10;
        int denominator = 4;

        // Act
        float result = oper.Division(numerator, denominator);

        // Assert
        assertEquals(2.5f, result, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivision_Exception() {
        // Arrange
        int numerator = 5;
        int denominator = 0;

        // Act
        oper.Division(numerator, denominator); 
        
        // Assert: Handled by (expected = IllegalArgumentException.class) above.
    }

    @Test
    public void testFactorial_Zero() {
        // Arrange, Act, Assert
        assertEquals(1, oper.Factorial(0));
    }

    @Test
    public void testFactorial_Num() {
        // Arrange
        int input = 5;

        // Act
        long result = oper.Factorial(input);

        // Assert
        assertEquals(120, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorial_Exception() {
        // Act
        oper.Factorial(-5);
    }

    @Test
    public void testIsPrime_BoundaryValues() {
        assertFalse(oper.isPrime(0));
        assertFalse(oper.isPrime(1));
        assertFalse(oper.isPrime(-7));
    }

    @Test
    public void testIsPrime_TruePrimes() {
        assertTrue(oper.isPrime(2));  
        assertTrue(oper.isPrime(3));
        assertTrue(oper.isPrime(17)); 
    }

    @Test
    public void testIsPrime_FalsePrimes() {
        assertFalse(oper.isPrime(4));
        assertFalse(oper.isPrime(9));
        assertFalse(oper.isPrime(100));
    }
}