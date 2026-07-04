package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class Test_Add {
    @Test
    public void test_add(){
        Add testing = new Add();
        int result = testing.addition(5,10);
        assertEquals(15, result);
    }
}
