package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when; 

public class OperationsTest {
    private Operations oper;

    @Before
    public void setup() { oper = new Operations(); }

    // Arrange
    public int a = 10;
    public int b = 5;

    @Test
    public void testAdd() {
        int result = oper.addition(a, b);     // Act
        assertEquals(15, result);   // Assert
    }
    @Test
    public void testSub() {
        int result = oper.subtraction(a, b);  // Act
        assertEquals(5, result);    // Assert
    }
    @Test
    public void testMul() {
        int result = oper.multiplication(a, b);   // Act
        assertEquals(50, result);       // Assert
    }
    @Test
    public void testDiv() {
        float result = oper.division(a, b);            // Act
        assertEquals(2.0, result, 0);  // Assert
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionByZeroThrowsException() {
        // 1. Arrange
        int x = 5;
        int y = 0;
        oper.division(x, y);   // Act & Assert
    }
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
    @Test
    public void testVerifyInteraction() {
        //Arrange
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        // Act
        service.fetchData();
        // Assert
        verify(mockApi).getData();
    }
}