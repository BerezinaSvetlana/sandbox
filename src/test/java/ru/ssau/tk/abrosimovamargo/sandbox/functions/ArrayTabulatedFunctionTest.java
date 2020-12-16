package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.exceptions.InterpolationException;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.testng.Assert.*;

public class ArrayTabulatedFunctionTest {
    double[] xValues = new double[]{1.0, 1.1, 1.2, 1.3, 1.4};
    double[] yValues = new double[]{2.0, 2.1, 2.2, 2.3, 2.4};
    private final MathFunction source = new SqrFunction();


    private ArrayTabulatedFunction testingArrayFunction() {
        return new ArrayTabulatedFunction(source, 1, 16, 6);
    }

    @Test
    public void testArrayTabulatedFunction() {
        double[] xValues = {4.1};
        double[] yValues = {6.2};
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(xValues, yValues));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(source, -37, -100, 2));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(source, -5, -15, -1));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(source, -4, -80, -2));
        assertThrows(IllegalArgumentException.class, () -> new ArrayTabulatedFunction(source, 4, -8, 1));
    }

    @Test
    public void testGetCount() {
        assertEquals(testingArrayFunction().getCount(), 6);
        assertNotEquals(testingArrayFunction().getCount(), 7);
    }

    @Test
    public void testApply() {
        ArrayTabulatedFunction testingApply = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingApply.apply(0.5), 2.0555, delta);
        assertEquals(testingApply.apply(1.3), 2.3, delta);
        assertEquals(testingApply.apply(4.2), 1.977777, delta);
        assertEquals(testingApply.apply(1.35), 2.2944, delta);
    }

    @Test
    public void testFloorIndexOfX() {
        ArrayTabulatedFunction testingFloorIndexOfX = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingFloorIndexOfX.floorIndexOfX(1.35), 3, delta);
        assertEquals(testingFloorIndexOfX.floorIndexOfX(1.43), 5, delta);
        assertNotEquals(testingFloorIndexOfX.floorIndexOfX(1.43), 4);
    }

    @Test
    public void testExtrapolateLeft() {
        ArrayTabulatedFunction testingExtrapolateLeft = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingExtrapolateLeft.extrapolateLeft(1.5), 1.94444, delta);
        assertEquals(testingExtrapolateLeft.extrapolateLeft(-1.5), 2.27777, delta);
        assertNotEquals(testingExtrapolateLeft.extrapolateLeft(1.5), 40.0);
    }

    @Test
    public void testExtrapolateRight() {
        ArrayTabulatedFunction testingExtrapolateRight = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingExtrapolateRight.extrapolateRight(5.0), 1.88888, delta);
        assertNotEquals(testingExtrapolateRight.extrapolateRight(2.45), 2.18);
    }
    @Test
    public void testInterpolate() {
        final double DELTA = 0.0001;
        ArrayTabulatedFunction testingInterpolate = new ArrayTabulatedFunction(xValues, yValues);
        assertEquals(testingInterpolate.interpolate(1.23, testingInterpolate.floorIndexOfX(1.23)), 2.19666, DELTA);
        assertNotEquals(testingInterpolate.interpolate(1.33, testingInterpolate.floorIndexOfX(1.33)), 8.43, DELTA);
        assertEquals(testingArrayFunction().interpolate(1.41, testingArrayFunction().floorIndexOfX(1.41)), 3.0499, DELTA);
        assertEquals(testingArrayFunction().interpolate(1.35, testingArrayFunction().floorIndexOfX(1.35)), 2.75, DELTA);
        assertNotEquals(testingArrayFunction().interpolate(1.33, testingArrayFunction().floorIndexOfX(1.33)), 8.43, DELTA);
        assertThrows(InterpolationException.class, () -> testingInterpolate.interpolate(0.5, 2));
        assertThrows(InterpolationException.class, () -> testingArrayFunction().interpolate(7.5, 3));
    }

    @Test
    public void testInterpolateException() {

    }

    @Test
    public void testGetX() {
        ArrayTabulatedFunction testingGetX = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingGetX.getX(1), 1.1, delta);
        assertNotEquals(testingGetX.getX(1), 2.2, delta);
    }

    @Test
    public void testGetY() {
        ArrayTabulatedFunction testingGetY = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingGetY.getY(1), 2.1, delta);
        assertNotEquals(testingGetY.getY(1), 3.2, delta);
    }

    @Test
    public void testSetY() {
        ArrayTabulatedFunction testingSetY = new ArrayTabulatedFunction(xValues, yValues);
        testingSetY.setY(1, 2.28);
        final double delta = 0.0001;
        assertEquals(testingSetY.getY(1), 2.28, delta);
    }

    @Test
    public void testIndexOfX() {
        ArrayTabulatedFunction testingIndexOfX = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingIndexOfX.indexOfX(1.3), 3, delta);
        assertNotEquals(testingIndexOfX.indexOfX(1.5), 1, delta);
    }

    @Test
    public void testIndexOfY() {
        ArrayTabulatedFunction testingIndexOfY = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingIndexOfY.indexOfY(2.5), -1, delta);
        assertNotEquals(testingIndexOfY.indexOfY(2.1), 4, delta);
    }

    @Test
    public void testLeftBound() {
        ArrayTabulatedFunction testingLeftBound = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingLeftBound.leftBound(), 1.0, delta);
        assertNotEquals(testingLeftBound.leftBound(), 1.2, delta);
    }

    @Test
    public void testRightBound() {

        ArrayTabulatedFunction testingRightBound = new ArrayTabulatedFunction(xValues, yValues);
        final double delta = 0.0001;
        assertEquals(testingRightBound.rightBound(), 1.4, delta);
        assertNotEquals(testingRightBound.rightBound(), 1.6, delta);
    }
    @Test
    public void testIterator() {
        final double DELTA = 0.001;
        Iterator<Point> iterator = testingArrayFunction().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(point.x, testingArrayFunction().getX(i), DELTA);
            assertEquals(point.y, testingArrayFunction().getY(i++), DELTA);
        }
        System.out.println(i);
        i = 0;
        for (Point point : testingArrayFunction()) {
            assertEquals(point.x, testingArrayFunction().getX(i), DELTA);
            assertEquals(point.y, testingArrayFunction().getY(i++), DELTA);
        }
        System.out.println(i);
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}