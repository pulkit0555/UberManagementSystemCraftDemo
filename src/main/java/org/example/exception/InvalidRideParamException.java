package org.example.exception;

public class InvalidRideParamException extends RuntimeException {
  public InvalidRideParamException(final String message) {
    super(message);
  }
}
