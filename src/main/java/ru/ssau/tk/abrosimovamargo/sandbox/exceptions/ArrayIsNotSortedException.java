package ru.ssau.tk.abrosimovamargo.sandbox.exceptions;

import java.io.Serializable;

public class ArrayIsNotSortedException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -1553628713635315051L;

    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String message) {
        super(message);
    }
}
