package ru.ssau.tk.abrosimovamargo.sandbox.functions;

public class ConstantFunction implements MathFunction {
    private final double y;

    public ConstantFunction(double y) {
        this.y = y;
    }

    @Override
    public double apply(double x) {
        return y;
    }

    public double getConstant() {
        return y;
    }
}
