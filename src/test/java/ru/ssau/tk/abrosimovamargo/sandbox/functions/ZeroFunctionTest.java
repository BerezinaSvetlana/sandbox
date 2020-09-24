package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ZeroFunctionTest {
    ZeroFunction testFunction = new ZeroFunction();

    @Test
    public void testGetConstant() {
        assertEquals(testFunction.apply(123.1), 0.0);
        assertNotEquals(testFunction.apply(123.123), 1.12);
        assertNotEquals(testFunction.apply(123.123), 1.0);
    }
}