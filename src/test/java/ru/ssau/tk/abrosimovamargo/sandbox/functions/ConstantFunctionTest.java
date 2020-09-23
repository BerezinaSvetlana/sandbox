package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ConstantFunctionTest {
    ConstantFunction testFunction = new ConstantFunction(123.123);

    @Test
    public void testApply() {
        assertEquals(testFunction.apply(123.123), 123.123);
    }

    @Test
    public void testGetConctant() {
        assertEquals(testFunction.getConctant(), 123.123);
    }
}