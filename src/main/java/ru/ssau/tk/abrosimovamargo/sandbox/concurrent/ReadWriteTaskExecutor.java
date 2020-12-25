package ru.ssau.tk.abrosimovamargo.sandbox.concurrent;

import ru.ssau.tk.abrosimovamargo.sandbox.concurrent.ReadWriteTask;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.TabulatedFunction;
import ru.ssau.tk.abrosimovamargo.sandbox.functions.ZeroFunction;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        TabulatedFunction function = new LinkedListTabulatedFunction(new ZeroFunction(), 1, 10, 10);
        List<Thread> list = new ArrayList<>();
        ReadWriteTask myTask = new ReadWriteTask(function);
        for (int i = 0; i < 20; i++) {
            list.add(new Thread(myTask));
        }
        for (Thread thread : list) {
            thread.start();
        }
        Thread.sleep(2_000);
        System.out.println(function.toString());
    }
}
