package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.ArrayTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.Point;

import static org.testng.Assert.*;

public class TabulatedFunctionOperationServiceTest {
    private final double[] valuesX = new double[]{-32, -10, -1, 0, 1, 10, 32};
    private final double[] valuesY = new double[]{-5, -3, -1, -0, 1, 3, 5};
    ArrayTabulatedFunction testArrayFunction = new ArrayTabulatedFunction(valuesX, valuesY);
    LinkedListTabulatedFunction testListFunction = new LinkedListTabulatedFunction(valuesX, valuesY);

    @Test
    public void testAsPoints() {
        final double DELTA = 0.1;
        Point[] Points = TabulatedFunctionOperationService.asPoints(testArrayFunction);
        int i = 0;
        for (Point myPoint : Points) {
            assertEquals(myPoint.x, testArrayFunction.getX(i), DELTA);
            assertEquals(myPoint.y, testArrayFunction.getY(i++), DELTA);
        }
        assertEquals(testArrayFunction.getCount(), i);

        Points = TabulatedFunctionOperationService.asPoints(testListFunction);
        i = 0;
        for (Point myPoint : Points) {
            assertEquals(myPoint.x, testListFunction.getX(i), DELTA);
            assertEquals(myPoint.y, testListFunction.getY(i++), DELTA);
        }
        assertEquals(testListFunction.getCount(), i);
    }
}
