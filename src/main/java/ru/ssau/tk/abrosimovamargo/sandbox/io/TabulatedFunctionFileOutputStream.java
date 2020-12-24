package ru.ssau.tk.abrosimovamargo.sandbox.io;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.ArrayTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.*;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        try (BufferedOutputStream listOut = new BufferedOutputStream(new FileOutputStream("output/linked list function.bin"));
             BufferedOutputStream arrayOut = new BufferedOutputStream(new FileOutputStream("output/array function.bin"))) {

            double[] xValues = new double[]{1, 2, 3, 4, 5};
            double[] yValues = new double[]{6, 7, 8, 9, 10};

            ArrayTabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
            LinkedListTabulatedFunctionFactory linkedListFactory = new LinkedListTabulatedFunctionFactory();
            TabulatedFunction arrayFunction = arrayFactory.create(xValues, yValues);
            TabulatedFunction linkedListFunction = linkedListFactory.create(xValues, yValues);
            FunctionsIO.writeTabulatedFunction(arrayOut, arrayFunction);
            FunctionsIO.writeTabulatedFunction(listOut, linkedListFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}