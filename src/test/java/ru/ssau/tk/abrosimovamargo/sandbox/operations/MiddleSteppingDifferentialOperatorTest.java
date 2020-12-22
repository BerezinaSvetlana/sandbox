package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.SqrFunction;

import static org.testng.Assert.*;

public class MiddleSteppingDifferentialOperatorTest {

    private static final double STEP = 0.01;


    @Test
    public void testDerive() {
        SteppingDifferentialOperator differentialOperator = new MiddleSteppingDifferentialOperator(STEP);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(5), 9.9999, 0.0001);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(6), 11.9999, 0.0001);
    }

}