package ru.ssau.tk.abrosimovamargo.sandbox.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CompositeFunctionTest {

    @Test
    public void testApply() {
        MathFunction identityFunction = new IdentityFunction();
        MathFunction asinFunction = new AsinFunction();
        MathFunction compositeFunction = new CompositeFunction(identityFunction, asinFunction);
        assertEquals(compositeFunction.apply(1), Math.PI/2);
        MathFunction sqtFunction = new SqrFunction();
        MathFunction sqrsqr = new CompositeFunction(sqtFunction, sqtFunction);
        assertEquals(sqrsqr.apply(2), 16.0 );
        MathFunction identitysqr = new CompositeFunction(identityFunction, sqtFunction);
        assertEquals(identitysqr.apply(6), 36.0);
        double result = sqtFunction.andThen(asinFunction).apply(0.0);
        assertEquals(result, 0.0);
    }
}