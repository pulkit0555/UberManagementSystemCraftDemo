package org.example.exception;

public class DriverNotFoundException extends RuntimeException {
  public DriverNotFoundException(final String message) {
    super(message);
  }
}
