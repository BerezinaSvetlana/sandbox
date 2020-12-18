package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.SqrFunction;

import static org.testng.Assert.*;

public class LeftSteppingDifferentialOperatorTest {

    private final static double STEP = 0.01;
    final double DELTA = 0.1;

    @Test
    public void testDerive() {
        SteppingDifferentialOperator differentialOperator = new LeftSteppingDifferentialOperator(STEP);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(8), 15.9899, DELTA);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(3), 5.98999, DELTA);
    }
}