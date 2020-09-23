package ru.ssau.tk.abrosimovamargo.sandbox.functions;

public class CeilFunction implements MathFunction{
    @Override
    public double apply(double x) {
        return (Math.ceil(x));
    }
}
