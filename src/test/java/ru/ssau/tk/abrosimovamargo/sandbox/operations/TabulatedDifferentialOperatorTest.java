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
    @Test
    public void testDeriveSynchronously() {
        TabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(new double[]{5, 6, 7, 8, 9}, new double[]{25, 36, 49, 64, 81});
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTabulatedFunctionFactory());
        TabulatedFunction diffFunctionList = differentialOperator.deriveSynchronously(linkedListTabulatedFunction);

        TabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(new double[]{5, 6, 7, 8, 9}, new double[]{5, 6, 7, 8, 9});
        TabulatedDifferentialOperator differentialOperator1 = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        TabulatedFunction diffFunctionArray = differentialOperator1.deriveSynchronously(arrayTabulatedFunction);

        assertEquals(diffFunctionList.getX(0), 5.0);
        assertEquals(diffFunctionList.getX(1), 6.0);
        assertEquals(diffFunctionList.getX(2), 7.0);
        assertEquals(diffFunctionList.getX(3), 8.0);
        assertEquals(diffFunctionList.getX(4), 9.0);

        assertEquals(diffFunctionList.getY(0), 11.0);
        assertEquals(diffFunctionList.getY(1), 13.0);
        assertEquals(diffFunctionList.getY(2), 15.0);
        assertEquals(diffFunctionList.getY(3), 17.0);
        assertEquals(diffFunctionList.getY(4), 17.0);
        assertTrue(diffFunctionList instanceof LinkedListTabulatedFunction);

        assertEquals(diffFunctionArray.getX(0), 5.0);
        assertEquals(diffFunctionArray.getX(1), 6.0);
        assertEquals(diffFunctionArray.getX(2), 7.0);
        assertEquals(diffFunctionArray.getX(3), 8.0);
        assertEquals(diffFunctionArray.getX(4), 9.0);

        assertEquals(diffFunctionArray.getY(0), 1.0);
        assertEquals(diffFunctionArray.getY(1), 1.0);
        assertEquals(diffFunctionArray.getY(2), 1.0);
        assertEquals(diffFunctionArray.getY(3), 1.0);
        assertEquals(diffFunctionArray.getY(4), 1.0);
        assertTrue(diffFunctionArray instanceof ArrayTabulatedFunction);
    }
}