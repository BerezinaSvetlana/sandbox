package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import ru.ssau.tk.abrosimova.sandbox.exceptions.InterpolationException;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

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

    private LinkedListTabulatedFunction listFunction() {
        return new LinkedListTabulatedFunction(sqr, 1, 5, 5);
    }

    private LinkedListTabulatedFunction getListFunction() {
        return new LinkedListTabulatedFunction(sqr, 1, 9, 5);
    }

    private LinkedListTabulatedFunction getFunction() {
        return new LinkedListTabulatedFunction(sqr, -2, 2, 5);
    }


    @Test
    public void testLinkedListTabulatedFunction() {
        double[] xValues = {1.1};
        double[] yValues = {5.2};
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(xValues, yValues));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(sqr, -10, -34, 2));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(sqr, -5, -15, -1));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(sqr, -4, -80, -2));
        assertThrows(IllegalArgumentException.class, () -> new LinkedListTabulatedFunction(sqr, 4, -8, 5));
    }

    @Test
    public void testGetNode() {
        assertEquals(getListOfArray().getX(0), 1, DELTA);
        assertEquals(getListOfArray().getX(1), 2, DELTA);
        assertEquals(getListOfArray().getX(2), 3, DELTA);
        assertEquals(getListOfArray().getX(3), 4, DELTA);
        assertEquals(getListOfArray().getX(4), 5, DELTA);
        assertNotEquals(getListOfArray().getX(4), 4, DELTA);
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getX(-123));
        assertThrows(IllegalArgumentException.class, () -> getListOfArray().getX(-5));
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
        assertEquals(getListOfArray().extrapolateLeft(11), -1.2222222222222214, DELTA);
        assertEquals(getListOfMathFunction().extrapolateLeft(4), 25.181488203266788, DELTA);
        assertNotEquals(getListOfMathFunction().extrapolateLeft(4), 1, DELTA);
    }

    @Test
    public void testExtrapolateRight() {
        assertEquals(getListOfArray().extrapolateRight(11), 42.02564102564102, DELTA);
        assertEquals(getListOfMathFunction().extrapolateRight(4), 215.31948936282268, DELTA);
        assertNotEquals(getListOfMathFunction().extrapolateRight(4), 1, DELTA);
    }


    //assertThrows(InterpolationException.class, () -> function.interpolate(2, function.floorIndexOfX(-2)));
    //assertThrows(InterpolationException.class, () -> function.interpolate(0, function.floorIndexOfX(2)));

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
        LinkedListTabulatedFunction testListArray = getListOfArray();
        testListArray.setY(2, 60);
        assertEquals(testListArray.getY(2), 60, DELTA);
    }

    @Test
    public void testIndexOfX() {
        final LinkedListTabulatedFunction listFunction = getListFunction();
        final LinkedListTabulatedFunction function = getFunction();
        final LinkedListTabulatedFunction arrayListFunction = getArrayListFunction();
        assertEquals(getListOfArray().indexOfX(3), 2);
        assertEquals(getListOfMathFunction().indexOfX(5), 0);
        assertEquals(getListOfArray().indexOfX(50), -1);
        assertEquals(listFunction.indexOfX(7), 3, DELTA);
        assertEquals(function.indexOfX(0), 2);
        assertNotEquals(function.indexOfX(1000), Double.NaN);
        assertNotEquals(function.indexOfX(-1000), Double.NaN);
        assertEquals(function.indexOfX(Double.NaN), -1);
        assertEquals(function.indexOfX(5), -1);
        assertEquals(function.indexOfX(-5), -1);
        assertEquals(arrayListFunction.indexOfX(7), -1);
        assertNotEquals(arrayListFunction.indexOfX(1100), Double.NaN);
        assertEquals(arrayListFunction.indexOfX(Double.NaN), -1);
    }

    @Test
    public void testIndexOfY() {
        final LinkedListTabulatedFunction listFunction = getListFunction();
        final LinkedListTabulatedFunction arrayListFunction = getArrayListFunction();
        final LinkedListTabulatedFunction function = getFunction();
        assertEquals(getListOfArray().indexOfY(6), -1);
        assertNotEquals(getListOfArray().indexOfY(6), 1);
        assertEquals(getListOfMathFunction().indexOfY(3), -1);
        assertEquals(listFunction.indexOfY(49), 3, DELTA);
        assertEquals(function.indexOfY(1), 1);
        assertNotEquals(function.indexOfY(1000), Double.NaN);
        assertNotEquals(function.indexOfY(-1000), Double.NaN);
        assertEquals(function.indexOfY(Double.NaN), -1);
        assertEquals(function.indexOfY(5), -1);
        assertEquals(function.indexOfY(-5), -1);
        assertEquals(arrayListFunction.indexOfX(3), 2);
        assertNotEquals(arrayListFunction.indexOfX(3), Double.NaN);
        assertNotEquals(arrayListFunction.indexOfX(3), 1);
    }

    @Test
    public void testApply() {
        LinkedListTabulatedFunction testingApply = new LinkedListTabulatedFunction(xValues, yValues);
        final double delta = 0.1;
        assertEquals(testingApply.apply(-1.5), 14.0, delta);
        assertEquals(testingApply.apply(1.4), 10.5, delta);
        assertEquals(testingApply.apply(1.1), 10.9, delta);
        assertEquals(testingApply.apply(1.15), 10.8, delta);
        assertNotEquals(testingApply.apply(7.82), 1.2, delta);
        assertNotEquals(testingApply.apply(1.22), 1.2, delta);
        assertEquals(listFunction().apply(-1.0), -5.0, delta);
        assertEquals(listFunction().apply(1.5), 2.5, delta);
        assertEquals(listFunction().apply(1.1), 1.3, delta);
        assertEquals(listFunction().apply(1.4), 2.2, delta);
        assertEquals(listFunction().apply(1.15), 1.5, delta);
        assertNotEquals(listFunction().apply(7.25), 59.3, delta);
        assertEquals(testingApply.apply(1.0), 11.0, delta);
        assertEquals(testingApply.apply(2.0), 22.0, delta);
        assertEquals(testingApply.apply(3.0), 33.0, delta);
        assertEquals(testingApply.apply(4.0), 44.0, delta);
        assertEquals(listFunction().apply(1.0), 1.0, delta);
        assertEquals(listFunction().apply(2.0), 4.0, delta);
        assertEquals(listFunction().apply(3.0), 9.0, delta);
        assertEquals(listFunction().apply(4.0), 16.0, delta);
        assertEquals(listFunction().apply(5.0), 25.0, delta);
    }

    @Test
    public void testInterpolate() {
        final double DELTA = 0.0001;
        assertEquals(getListOfArray().interpolate(1.23, getListOfArray().floorIndexOfX(1.23)), 10.7188, DELTA);
        assertEquals(getListOfArray().interpolate(1.15, getListOfArray().floorIndexOfX(1.15)), 10.8166, DELTA);
        assertNotEquals(getListOfArray().interpolate(1.33, getListOfArray().floorIndexOfX(1.33)), 8.43, DELTA);
        assertThrows(InterpolationException.class, () -> getListOfArray().interpolate(0.5, 2));
        assertThrows(InterpolationException.class, () -> getListOfMathFunction().interpolate(7.5, 3));
    }

    @Test
    public void testIteratorWhile() {
        Iterator<Point> iterator = getListOfArray().iterator();
        Iterator<Point> iterator_1 = getListOfMathFunction().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(getListOfArray().getX(i), point.x, DELTA);
            assertEquals(getListOfArray().getY(i++), point.y, DELTA);
        }
        assertEquals(getListOfArray().getCount(), i);
        int j = 0;
        while (iterator_1.hasNext()) {
            Point point = iterator_1.next();
            assertEquals(getListOfMathFunction().getX(j), point.x, DELTA);
            assertEquals(getListOfMathFunction().getY(j++), point.y, DELTA);
        }
        assertEquals(getListOfMathFunction().getCount(), j);
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorForEach() {
        int i = 0;
        for (Point point : getListOfArray()) {
            assertEquals(getListOfArray().getX(i), point.x, DELTA);
            assertEquals(getListOfArray().getY(i++), point.y, DELTA);
        }
        assertEquals(getListOfArray().getCount(), i);
        int j = 0;
        for (Point point : getListOfMathFunction()) {
            assertEquals(getListOfMathFunction().getX(j), point.x, DELTA);
            assertEquals(getListOfMathFunction().getY(j++), point.y, DELTA);
        }
        assertEquals(getListOfMathFunction().getCount(), j);
    }
}