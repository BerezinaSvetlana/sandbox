package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.ArrayTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.testng.Assert.*;

public class TabulatedDifferentialOperatorTest {
    final double DELTA = 0.0001;
    private final double[] xValues = new double[]{1, 2, 3, 4, 5, 6};
    private final double[] yValues = new double[]{11, 22, 33, 44, 55, 66};

    @Test
    public void testDerive() {
        TabulatedFunction testArray = new ArrayTabulatedFunction(xValues, yValues);
        TabulatedDifferentialOperator differentialArrayOperator = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        testArray = differentialArrayOperator.derive(testArray);
        assertTrue(testArray instanceof ArrayTabulatedFunction);
        assertEquals(testArray.getX(0), 1, DELTA);
        assertEquals(testArray.getX(2), 3, DELTA);
        assertEquals(testArray.getX(4), 5, DELTA);
        assertEquals(testArray.getY(0), 11, DELTA);
        assertEquals(testArray.getY(2), 11, DELTA);

        TabulatedFunction testList = new LinkedListTabulatedFunction(xValues, yValues);
        TabulatedDifferentialOperator differentialListOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        testList = differentialListOperator.derive(testList);
        assertTrue(testList instanceof LinkedListTabulatedFunction);
        assertEquals(testList.getX(0), 1, DELTA);
        assertEquals(testList.getX(2), 3, DELTA);
        assertEquals(testList.getX(4), 5, DELTA);
        assertEquals(testList.getY(0), 11, DELTA);
        assertEquals(testList.getY(2), 11, DELTA);
    }
}