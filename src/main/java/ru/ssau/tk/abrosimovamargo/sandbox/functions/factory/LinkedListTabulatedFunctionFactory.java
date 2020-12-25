package ru.ssau.tk.abrosimovamargo.sandbox.functions.factory;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.MathFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);

    }

    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new LinkedListTabulatedFunction(source, xFrom, xTo, count);
    }
}

