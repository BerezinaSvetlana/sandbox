package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AbstractTabulatedFunctionTest {

    @Test
    public void testInterpolate() {
        AbstractTabulatedFunction mockedInterpolate = new MockTabulatedFunction();

        final double delta = 0.0001;
        assertEquals(mockedInterpolate.interpolate(1.5, 1.0, 2.0, 3.0, 4.0), 2.5, delta);
       }

    @Test
    public void testApply() {
        AbstractTabulatedFunction mockedApply = new MockTabulatedFunction();

        final double delta = 0.0001;
        assertEquals(mockedApply.apply(1.3), 4.0, delta);
        assertEquals(mockedApply.apply(4.0), 4.0, delta);
        assertNotEquals(mockedApply.apply(1.3), 5.2);
    }
}