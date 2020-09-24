package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AsinFunctionTest {

    @Test
    public void testApply() {

        AsinFunction test = new AsinFunction();
        assertEquals(test.apply(0),0.0);
        assertEquals(test.apply(1),Math.PI / 2);
        assertEquals(test.apply(-1),- Math.PI / 2);
    }
}