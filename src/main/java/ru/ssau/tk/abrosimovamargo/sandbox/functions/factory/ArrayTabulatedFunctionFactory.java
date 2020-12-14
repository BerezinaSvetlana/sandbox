package ru.ssau.tk.abrosimovamargo.sandbox.functions.factory;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.ArrayTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}
