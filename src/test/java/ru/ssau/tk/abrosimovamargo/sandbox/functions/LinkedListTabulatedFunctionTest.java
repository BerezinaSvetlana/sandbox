package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LinkedListTabulatedFunctionTest {
        private final double[] xValues = new double[]{1, 2, 3, 4, 5};
        private final double[] yValues = new double[]{11, 22, 33, 44, 55};
        private final MathFunction testFunction = new SqrFunction();

        private LinkedListTabulatedFunction getListOfArray() {

            return new LinkedListTabulatedFunction(xValues, yValues);
        }

        private LinkedListTabulatedFunction getListOfMathFunction() {
            return new LinkedListTabulatedFunction(testFunction, 5, 15, 30);
        }

    @Test
    public void testFloorIndexOfX() {
    }

    @Test
    public void testExtrapolateLeft() {
    }

    @Test
    public void testExtrapolateRight() {
    }

    @Test
    public void testInterpolate() {
    }

    @Test
    public void testGetCount() {
    }

    @Test
    public void testGetX() {
    }

    @Test
    public void testGetY() {
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