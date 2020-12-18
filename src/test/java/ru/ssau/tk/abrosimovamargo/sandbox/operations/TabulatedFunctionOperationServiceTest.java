package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.abrosimovamargo.sandbox.exceptions.InconsistentFunctionsException;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.ArrayTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.Point;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.LinkedListTabulatedFunctionFactory;

import static org.testng.Assert.*;

public class TabulatedFunctionOperationServiceTest {
    private final double[] valuesX = new double[]{-32, -10, -1, 0, 1, 10, 32};
    private final double[] valuesY = new double[]{-5, -3, -1, -0, 1, 3, 5};
    private final double[] valuesYForList = new double[]{10, 20, 30, 40, 50, 60, 70};
    private final TabulatedFunctionOperationService operationServiceArray = new TabulatedFunctionOperationService();
    private final TabulatedFunctionOperationService operationServiceList = new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory());
    private final TabulatedFunction testArrayFunction = new ArrayTabulatedFunction(valuesX, valuesY);
    private final TabulatedFunction testListFunction = new LinkedListTabulatedFunction(valuesX, valuesYForList);

    ArrayTabulatedFunction getTestArray() {
        return new ArrayTabulatedFunction(valuesX, valuesY);
    }

    LinkedListTabulatedFunction getTestList() {
        return new LinkedListTabulatedFunction(valuesX, valuesYForList);
    }
    @Test
    public void testAsPoints() {
        ArrayTabulatedFunction testArrayFunction = getTestArray();
        final double DELTA = 0.1;
        Point[] Points = TabulatedFunctionOperationService.asPoints(testArrayFunction);
        int i = 0;
        for (Point myPoint : Points) {
            assertEquals(myPoint.x, testArrayFunction.getX(i), DELTA);
            assertEquals(myPoint.y, testArrayFunction.getY(i++), DELTA);
        }
        assertEquals(testArrayFunction.getCount(), i);

        LinkedListTabulatedFunction testListFunction = getTestList();
        Points = TabulatedFunctionOperationService.asPoints(testListFunction);
        i = 0;
        for (Point myPoint : Points) {
            assertEquals(myPoint.x, testListFunction.getX(i), DELTA);
            assertEquals(myPoint.y, testListFunction.getY(i++), DELTA);
        }
        assertEquals(testListFunction.getCount(), i);
    }

    @Test
    public void testGetFactory() {
        assertTrue(new TabulatedFunctionOperationService().getFactory() instanceof ArrayTabulatedFunctionFactory);
        assertTrue(new TabulatedFunctionOperationService(new LinkedListTabulatedFunctionFactory()).getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }

    @Test
    public void testSetFactory() {
        TabulatedFunctionOperationService myObj = new TabulatedFunctionOperationService();
        myObj.setFactory(new LinkedListTabulatedFunctionFactory());
        assertTrue(myObj.getFactory() instanceof LinkedListTabulatedFunctionFactory);
    }

    @Test
    public void testSum() {
        final double[] errorX1 = new double[]{0, 1, 2};
        final double[] errorY1 = new double[]{0, 1, 2};
        TabulatedFunction errorTest1 = new ArrayTabulatedFunction(errorX1, errorY1);
        assertThrows(InconsistentFunctionsException.class, () -> operationServiceList.sum(testListFunction, errorTest1));
        final double[] errorX2 = new double[]{-15, -10, -1, 0, 1, 10, 15};
        TabulatedFunction errorTest2 = new ArrayTabulatedFunction(errorX2, valuesY);
        assertThrows(InconsistentFunctionsException.class, () -> operationServiceList.sum(testListFunction, errorTest2));
        TabulatedFunction testSumOfArrays = operationServiceArray.sum(testArrayFunction, testArrayFunction);
        assertTrue(testSumOfArrays instanceof ArrayTabulatedFunction);
        int i = 0;
        for (Point point : testSumOfArrays) {
            assertEquals(point.x, valuesX[i]);
            assertEquals(point.y, valuesY[i] + valuesY[i++]);
        }
        TabulatedFunction testSumOfLists = operationServiceList.sum(testListFunction, testListFunction);
        assertTrue(testSumOfLists instanceof LinkedListTabulatedFunction);
        i = 0;
        for (Point point : testSumOfLists) {
            assertEquals(point.x, valuesX[i]);
            assertEquals(point.y, valuesYForList [i] + valuesYForList [i++]);
        }
        TabulatedFunction testSumOfArrayAndList = operationServiceArray.sum(testArrayFunction, testListFunction);
        assertTrue(testSumOfArrayAndList instanceof ArrayTabulatedFunction);
        i = 0;
        for (Point point : testSumOfArrayAndList) {
            assertEquals(point.x, valuesX[i]);
            assertEquals(point.y, valuesY[i] + valuesYForList[i++]);
        }
    }

    @Test
    public void testSubtract() {
        ArrayTabulatedFunction testArrayFunction = getTestArray();
        LinkedListTabulatedFunction testListFunction = getTestList();
        TabulatedFunction testSubtractOfArrays = new TabulatedFunctionOperationService().subtract(testArrayFunction, testArrayFunction);
        int i = 0;
        for (Point point : testSubtractOfArrays) {
            assertEquals(point.x, valuesX[i]);
            assertEquals(point.y, valuesY[i] - valuesY[i++]);
        }
        TabulatedFunction testSubtractOfLists = new TabulatedFunctionOperationService().subtract(testListFunction, testListFunction);
        i = 0;
        for (Point point : testSubtractOfLists) {
            assertEquals(point.x, valuesX[i]);
            assertEquals(point.y, valuesYForList[i] - valuesYForList[i++]);
        }
        TabulatedFunction testSubtractOfArrayAndList = new TabulatedFunctionOperationService().subtract(testArrayFunction, testListFunction);
        i = 0;
        for (Point point : testSubtractOfArrayAndList) {
            assertEquals(point.x, valuesX[i]);
            assertEquals(point.y, valuesY[i] - valuesYForList[i++]);
        }
    }
}
