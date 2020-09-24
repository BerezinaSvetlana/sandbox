package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {
    private final double DELTA = 0.00001;

    @Test
    public void testApply() {
        MathFunction identityFunction = new IdentityFunction();
        MathFunction asinFunction = new AsinFunction();
        MathFunction compositeFunction = new CompositeFunction(identityFunction, asinFunction);
        assertEquals(compositeFunction.apply(1), Math.PI/2, DELTA);
        MathFunction sqrFunction = new SqrFunction();
        MathFunction sqrSqr = new CompositeFunction(sqrFunction, sqrFunction);
        assertEquals(sqrSqr.apply(2), 16.0, DELTA);
        MathFunction identitySqr = new CompositeFunction(identityFunction, sqrFunction);
        assertEquals(identitySqr.apply(6), 36.0, DELTA);
        double result = sqrFunction.andThen(asinFunction).apply(0.0);
        assertEquals(result, 0.0, DELTA);
        double result1 = sqrFunction.andThen(asinFunction).apply(0.5);
        assertEquals(result1, Math.pow(Math.PI/6,2), DELTA);
    }
}