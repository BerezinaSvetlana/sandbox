package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    UnitFunction testFunction = new UnitFunction();

    @Test
    public void testApply() {
        assertEquals(testFunction.apply(123.123), 1.0);
        assertNotEquals(testFunction.apply(123.123), 1.12);
        assertNotEquals(testFunction.apply(123.123), 0.0);
    }

    @Test
    public void testGetConstant() {
        assertEquals(testFunction.getConstant(), 1.0);
    }
}