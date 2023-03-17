package org.example.exception;

public class TripNotFoundException extends RuntimeException {
  public TripNotFoundException(final String message) {
    super(message);
  }
}
