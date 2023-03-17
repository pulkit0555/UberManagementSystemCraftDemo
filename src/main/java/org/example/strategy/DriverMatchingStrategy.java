package org.example.strategy;

import org.example.model.Driver;
import org.example.model.Rider;

import java.util.List;
import java.util.Optional;

public interface DriverMatchingStrategy {

  Optional<Driver> findDriver(Rider rider, List<Driver> nearByDrivers, int origin, int destination);
}
