package org.example.controllers;

import java.util.List;

import org.example.manager.RiderManager;
import org.example.manager.TripManager;
import org.example.model.Rider;

import org.example.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RidersController {
    private RiderManager riderManager;
    private TripManager tripManager;

    public RidersController(RiderManager riderManager, TripManager tripManager) {
        this.riderManager = riderManager;
        this.tripManager = tripManager;
    }

    @RequestMapping(value = "/register/rider", method = RequestMethod.POST)
    public ResponseEntity registerRider(final Integer riderId, final String riderName) {
        riderManager.createRider(new Rider(riderId, riderName));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/bookingDetails", method = RequestMethod.GET)
    public ResponseEntity fetchHistory(final Integer riderId) {
        List<Trip> trips = tripManager.tripHistory(riderManager.getRider(riderId));
        return ResponseEntity.ok(trips);
    }
}
