package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantFunctionTest {
    ConstantFunction testFunction = new ConstantFunction(123.123);

    @Test
    public void testApply() {
        assertEquals(testFunction.apply(123.123), 123.123);
        assertNotEquals(testFunction.apply(123.123), 1.23);
        assertEquals(testFunction.apply(123.123), 12.123);
    }

    @Test
    public void testGetConstant() {
        assertEquals(testFunction.getConstant(), 123.123);
    }
}