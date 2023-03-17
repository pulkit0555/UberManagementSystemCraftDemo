package org.example.strategy;

import org.example.model.Driver;
import org.example.model.Rider;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public class OptimalDriverStrategy implements DriverMatchingStrategy {

  @Override
  public Optional<Driver> findDriver(
      @NonNull final Rider rider,
      @NonNull final List<Driver> nearByDrivers,
      final int origin,
      final int destination) {
    return nearByDrivers.stream().findAny();
  }
}
