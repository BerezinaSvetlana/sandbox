package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UnitFunctionTest {
    UnitFunction testFunction = new UnitFunction();

    @Test
    public void testApply() {
        assertEquals(testFunction.apply(123.123), 1.0);
    }

    @Test
    public void testGetConctant() {
        assertEquals(testFunction.getConctant(), 1.0);
    }
}