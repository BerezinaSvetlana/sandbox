package ru.ssau.tk.abrosimovamargo.sandbox.functions.factory;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.ArrayTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;

public class LinkedFunctionFactoryTest {

    @Test
    public void testCreate() {
        double[] x = {1, 2, 3, 4, 5};
        double[] y = {10, 20, 30, 40, 50};
        TabulatedFunctionFactory listFactory = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction otherListFactory = listFactory.create(x, y);
        assertTrue(otherListFactory instanceof LinkedListTabulatedFunction);
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunction otherArrayFactory = arrayFactory.create(x, y);
        assertTrue(otherArrayFactory instanceof ArrayTabulatedFunction);
    }
}
