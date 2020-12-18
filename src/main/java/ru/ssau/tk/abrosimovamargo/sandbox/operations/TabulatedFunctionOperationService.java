package ru.ssau.tk.abrosimovamargo.sandbox.operations;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.Point;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;

public class TabulatedFunctionOperationService {
    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int i = 0;
        Point[] points = new Point[tabulatedFunction.getCount()];
        for (Point myPoint : tabulatedFunction) {
            points[i++] = myPoint;
        }
        return points;
    }
}

