package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.MathFunction;

public abstract class SteppingDifferentialOperator implements DifferentialOperator<MathFunction> {
    protected  double step;

    public SteppingDifferentialOperator(double step) {
        if (step <= 0 || Double.isInfinite(step) || Double.isNaN(step)) {
            throw new IllegalArgumentException("Step is wrong");
        }
        this.step = step;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        this.step = step;
    }
}

