package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SqrFunctionTest {

    @Test
    public void testApply() {
        SqrFunction test = new SqrFunction();
        assertEquals(test.apply(2), 4.0);
        assertEquals(test.apply(-2), 4.0);
        assertEquals(test.apply(0), 0.0);
    }
}