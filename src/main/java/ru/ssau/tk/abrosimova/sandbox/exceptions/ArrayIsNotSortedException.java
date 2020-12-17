package ru.ssau.tk.abrosimova.sandbox.exceptions;

public class ArrayIsNotSortedException extends RuntimeException{
    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String message) {
        super(message);
    }
}
