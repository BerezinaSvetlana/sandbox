package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AsinFunctionTest {
    private final double DELTA = 0.0001;

    @Test
    public void testApply() {

        MathFunction test = new AsinFunction();
        assertEquals(test.apply(0), 0.0, DELTA);
        assertEquals(test.apply(1), Math.PI / 2, DELTA);
        assertEquals(test.apply(-1), -Math.PI / 2, DELTA);
    }
}