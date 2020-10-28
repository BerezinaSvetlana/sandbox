package ru.ssau.tk.abrosimovamargo.sandbox.functions;

public abstract class AbstractTabulatedFunction implements TabulatedFunction {
    abstract int floorIndexOfX(double x);
    abstract double extrapolateLeft(double x);
    abstract double extrapolateRight(double x);
    abstract double interpolate(double x, int floorIndex);

    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY){
        return leftY+(rightY-leftY)*(x-leftX)/(rightX-leftY);
    }

    public double apply(double x){
        if (x < leftBound()) {
            return extrapolateLeft(x);
        } else if (x > rightBound()) {
            return extrapolateRight(x);
        } else if (indexOfX(x) != -1) {
            return getY(indexOfX(x));
        } else {
            return interpolate(x, floorIndexOfX(x));
        }
    }
}
