package ru.ssau.tk.abrosimovamargo.sandbox.exceptions;

import java.io.Serializable;

public class DifferentLengthOfArraysException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = -5206262876953373365L;

    public DifferentLengthOfArraysException() {
    }

    public DifferentLengthOfArraysException(String message) {
        super(message);
    }
}
