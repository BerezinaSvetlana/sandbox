package ru.ssau.tk.abrosimovamargo.sandbox.functions.factory;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.MathFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);
    TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count);
}
