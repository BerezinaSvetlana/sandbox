package ru.ssau.tk.abrosimovamargo.sandbox.exceptions;

import java.io.Serializable;

public class InterpolationException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 3303545512972126588L;

    public InterpolationException() {
    }

    public InterpolationException(String message) {
        super(message);
    }
}
