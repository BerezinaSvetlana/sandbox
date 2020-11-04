package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {
    final double DELTA = 0.0001;

    private final double[] xValues = new double[]{1, 2, 3, 4, 5};
    private final double[] yValues = new double[]{11, 22, 33, 44, 55};
    private final MathFunction sqr = new SqrFunction();
    private final MathFunction testFunction = new SqrFunction();

    private LinkedListTabulatedFunction getListOfArray() {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    private LinkedListTabulatedFunction getListOfMathFunction() {
        return new LinkedListTabulatedFunction(testFunction, 5, 15, 30);
    }

    private LinkedListTabulatedFunction getArrayListFunction() {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    private LinkedListTabulatedFunction getListFunction() {
        return new LinkedListTabulatedFunction(sqr, 1, 9, 5);
    }

    private LinkedListTabulatedFunction getFunction() {
        return new LinkedListTabulatedFunction(sqr, -2, 2, 5);
    }

    @Test
    public void testGetNode() {
        assertEquals(getListOfArray().getX(0), 1, DELTA);
        assertEquals(getListOfArray().getX(1), 2, DELTA);
        assertEquals(getListOfArray().getX(2), 3, DELTA);
        assertEquals(getListOfArray().getX(3), 4, DELTA);
        assertEquals(getListOfArray().getX(4), 5, DELTA);
        assertNotEquals(getListOfArray().getX(4), 4, DELTA);
    }

    @Test
    public void testFloorIndexOfX() {
        assertEquals(getListOfArray().floorIndexOfX(5), 3);
        assertEquals(getListOfMathFunction().floorIndexOfX(66), 30);
        assertThrows(IllegalArgumentException.class, () -> {
            getListOfArray().floorIndexOfX(-13);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            getListOfArray().floorIndexOfX(-66);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            getListOfArray().floorIndexOfX(-666);
        });
    }

    @Test
    public void testExtrapolateLeft() {
        assertEquals(getListOfArray().extrapolateLeft(11), 0, DELTA);
        assertEquals(getListOfMathFunction().extrapolateLeft(4), 0, DELTA);
        assertNotEquals(getListOfMathFunction().extrapolateLeft(4), 1, DELTA);
    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(getListOfArray().extrapolateRight(11), 0, DELTA);
        assertEquals(getListOfMathFunction().extrapolateRight(4), 0, DELTA);
        assertNotEquals(getListOfMathFunction().extrapolateRight(4), 1, DELTA);
    }

    @Test
    public void testInterpolate() {
    }

    @Test
    public void testGetCount() {
        assertEquals(getListOfArray().getCount(), 5, DELTA);
        assertNotEquals(getListOfMathFunction().getCount(), 60, DELTA);
    }

    @Test
    public void testGetX() {
        assertEquals(getListOfArray().getX(1), 2, DELTA);
        assertEquals(getListOfMathFunction().getX(1), 5.3448275, DELTA);
        assertEquals(getListOfMathFunction().getX(5), 6.7241379, DELTA);
    }

    @Test
    public void testGetY() {
        assertEquals(getListOfArray().getY(0), 11, DELTA);
        assertEquals(getListOfMathFunction().getY(0), 25, DELTA);
        assertThrows(IllegalArgumentException.class, () -> {
            getListOfArray().floorIndexOfX(-13);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            getListOfArray().floorIndexOfX(-66);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            getListOfArray().floorIndexOfX(-13);
        });
    }

    @Test
    public void testSetY() {
    }

    @Test
    public void testIndexOfX() {
    }

    @Test
    public void testIndexOfY() {
    }

    @Test
    public void testLeftBound() {
    }

    @Test
    public void testRightBound() {
    }
}