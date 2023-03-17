package org.example;

import org.example.exception.DriverAlreadyPresentException;
import org.example.exception.DriverNotFoundException;
import org.example.manager.DriverManager;
import org.example.model.Driver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DriverManagerTest {

	DriverManager driverManager;

	@BeforeEach
	void setup() {
		driverManager = new DriverManager();
	}

	@Test
	void test_createDriverAndGetDrivers() {
		// Given.
		Driver dummyDriver = new Driver(2, "Shubham", 918171651, "d1@gmail.com", "DL123");
		driverManager.createDriver(new Driver(1, "Amar",918171651, "d1@gmail.com", "DL123"));
		driverManager.createDriver(new Driver(2, "Prateek",918171651, "d1@gmail.com", "DL123"));
		driverManager.createDriver(new Driver(3, "Rajat", 918171651, "d1@gmail.com", "DL123"));

		// Then.
		assertThrows(DriverAlreadyPresentException.class, () -> {
			// When.
			driverManager.createDriver(dummyDriver);
		});

		// Then.
		assertEquals(3, driverManager.getDrivers().size());
	}

	@Test
	void test_updateDriverAvailability() {

		// Given.
		driverManager.createDriver(new Driver(1, "Amar",918171651, "d1@gmail.com", "DL123"));
		driverManager.createDriver(new Driver(2, "Prateek", 918171651, "d1@gmail.com", "DL123"));
		driverManager.createDriver(new Driver(3, "Rajat", 918171651, "d1@gmail.com", "DL123"));

		assertEquals(3, driverManager.getDrivers().size());

		// When.
		driverManager.updateDriverAvailability(3, false);

		// Then.
		assertEquals(2, driverManager.getDrivers().size());

		// Then.
		assertThrows(DriverNotFoundException.class, () -> {
			// When.
			driverManager.updateDriverAvailability(10, false);
		});
	}
}
