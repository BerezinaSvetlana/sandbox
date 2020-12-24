package ru.ssau.tk.abrosimovamargo.sandbox.io;

import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.abrosimovamargo.sandbox.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        File arrayFile = new File("input/binary function.bin");
        LinkedListTabulatedFunctionFactory listFact = new LinkedListTabulatedFunctionFactory();
        ArrayTabulatedFunctionFactory arrayFact = new ArrayTabulatedFunctionFactory();
        try (BufferedInputStream inArray = new BufferedInputStream(new FileInputStream(arrayFile))) {
            TabulatedFunction arrayFunction = FunctionsIO.readTabulatedFunction(inArray, arrayFact);

            System.out.println(arrayFunction.toString());
        } catch (IOException err) {
            err.printStackTrace();

        }
        try {
            BufferedReader inList = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Введите размер и значения функции");
            TabulatedFunction listFunction = FunctionsIO.readTabulatedFunction(inList, listFact);

            TabulatedDifferentialOperator diffList = new TabulatedDifferentialOperator(listFact);
            System.out.println(diffList.derive(listFunction).toString());

        } catch (IOException err) {
            err.printStackTrace();
        }
    }
}
