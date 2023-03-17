package org.example.controllers;

import org.example.manager.DriverManager;
import org.example.manager.TripManager;
import org.example.model.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabsController {
  private DriverManager driverManager;
  private TripManager tripManager;

  public CabsController(DriverManager driverManager, TripManager tripManager) {
    this.driverManager = driverManager;
    this.tripManager = tripManager;
  }

  @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
  public ResponseEntity registerCab(final Integer driverId, final String driverName, Integer mobile, String email, String dlNumber) {
    driverManager.createDriver(new Driver(driverId, driverName, mobile, email, dlNumber));
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "/update/cab/availability", method = RequestMethod.POST)
  public ResponseEntity updateCabAvailability(final Integer cabId, final Boolean newAvailability) {
      driverManager.updateDriverAvailability(cabId, newAvailability);
    return ResponseEntity.ok("");
  }

  @RequestMapping(value = "/getAllCabs", method = RequestMethod.GET)
  public ResponseEntity getAllCabs() {
      driverManager.getDrivers();
    return ResponseEntity.ok("");
  }
}
