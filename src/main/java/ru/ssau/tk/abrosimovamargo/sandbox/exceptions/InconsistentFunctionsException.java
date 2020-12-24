package ru.ssau.tk.abrosimovamargo.sandbox.exceptions;

import java.io.Serializable;

public class InconsistentFunctionsException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = -7208590465872087763L;

    public InconsistentFunctionsException() {
    }

    public InconsistentFunctionsException(String message) {
        super(message);
    }
}