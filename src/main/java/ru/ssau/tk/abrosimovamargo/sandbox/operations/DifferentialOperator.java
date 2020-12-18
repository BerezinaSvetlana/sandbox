package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.MathFunction;

public interface DifferentialOperator<T extends MathFunction> {
    T derive(T function);
}
