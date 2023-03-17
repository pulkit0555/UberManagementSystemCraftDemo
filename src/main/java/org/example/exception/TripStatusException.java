package org.example.exception;

public class TripStatusException extends RuntimeException {
  public TripStatusException(final String message) {
    super(message);
  }
}
