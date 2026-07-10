package com.example;

// 1. Core Mockito imports
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
    @Test
    public void testMultipleValues(){
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First Call", "Second Call");
        MyService service = new MyService(mockApi);
        String firstResult = service.fetchData();
        assertEquals("First Call", firstResult);
        String secondResult = service.fetchData();
        assertEquals("Second Call", secondResult);
    }
    @Test
    public void testInteractionOrder(){
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First Action", "Second Action");
        MyService service = new MyService(mockApi);
        service.fetchDataSeq();
        org.mockito.InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).getData();
    }
    @Test(expected = RuntimeException.class)
    public void testVoidThrowsException(){
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Access Denied")).when(mockApi).checkAccess();
        MyService service = new MyService(mockApi);
        service.performAction();
    }
}