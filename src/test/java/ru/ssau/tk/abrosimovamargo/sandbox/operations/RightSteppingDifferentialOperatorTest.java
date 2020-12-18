package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import org.testng.annotations.Test;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.SqrFunction;

import static org.testng.Assert.*;

public class RightSteppingDifferentialOperatorTest {


    private static final double STEP = 0.01;
    final double DELTA = 0.1;

    @Test
    public void testDerive() {
        SteppingDifferentialOperator differentialOperator = new RightSteppingDifferentialOperator(STEP);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(3), 6.0099, DELTA);
        assertEquals(differentialOperator.derive(new SqrFunction()).apply(4), 8.009, DELTA);
    }
}