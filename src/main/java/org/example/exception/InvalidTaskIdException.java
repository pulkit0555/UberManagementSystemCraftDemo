package org.example.exception;

public class InvalidTaskIdException extends RuntimeException {
    public InvalidTaskIdException(final String message) {
        super(message);
    }
}
