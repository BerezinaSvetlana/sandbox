package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class IdentityFunctionTest {

    @Test
    public void testApply() {
        IdentityFunction test = new IdentityFunction();
        assertEquals(test.apply(1),1.0);
        assertEquals(test.apply(5),5.0);
        assertEquals(test.apply(-1),-1.0);
        assertEquals(test.apply(1),1.0);
    }
}