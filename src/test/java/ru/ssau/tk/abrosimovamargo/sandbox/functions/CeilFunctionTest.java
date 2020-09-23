package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CeilFunctionTest {

    @Test
    public void testApply() {
        CeilFunction test = new CeilFunction();
        assertEquals(test.apply(4.66), 5.0);
        assertEquals(test.apply(-4.66), -4.0);
    }
}