package org.example.manager;

import org.example.exception.DriverAlreadyPresentException;
import org.example.exception.DriverNotFoundException;
import org.example.exception.InvalidTaskIdException;
import org.example.model.Driver;
import org.example.tasks.BackgroundVerificationTaskProcessor;
import org.example.tasks.DocumentCollectionTaskProcessor;
import org.example.tasks.TaskProcessor;
import org.example.tasks.TrackingDeviceShippingTaskProcessor;

import java.util.*;
import java.util.stream.Collectors;

/** Driver manager class is used to manage all operations related to driver. */
public class DriverManager {

  private Map<Integer, Driver> drivers = new HashMap<>();
  //Map to store status of all tasks
  private Map<Integer, HashMap<Integer,Boolean>> driverTaskStatus =  new HashMap<>();
  private List<Integer> taskIdList = new ArrayList<Integer>(Arrays.asList(1, 2, 3));

  /**
   * Method to register a new Driver into the application.
   *
   * @param driver Object
   * @throws DriverAlreadyPresentException exception if driver is already present
   */
  public void createDriver(final Driver driver) {
    if (drivers.containsKey(driver.getId())) {
      throw new DriverAlreadyPresentException(
          "Driver with driver id = " + driver.getId() + " already present, try with different Id.");
    }

    drivers.put(driver.getId(), driver);
  }

  /**
   * Method to update whether a driver is accepting ride or not.
   *
   * @param driverId integer
   * @param newAvailability boolean
   * @throws DriverNotFoundException If Driver not found for the given driver id.
   */
  public void updateDriverAvailability(final int driverId, boolean newAvailability) {
    if (!drivers.containsKey(driverId)) {
      throw new DriverNotFoundException(
          "No driver with driver id = " + driverId + ", try with correct driver Id.");
    }

    drivers.get(driverId).setAcceptingRider(newAvailability);
  }

  public List<Driver> getDrivers() {
    return drivers.values().stream().filter(Driver::isAvailable).collect(Collectors.toList());
  }

  public void executeTasks(final int driverId, final Integer taskId) {
    if (!drivers.containsKey(driverId)) {
      throw new DriverNotFoundException(
              "No driver with driver id = " + driverId + ", try with correct driver Id.");
    }
    if(!taskIdList.contains(taskId)) {
      throw new InvalidTaskIdException("No such task found with taskId = "+taskId+" ,please enter a valid task to be completed.");
    }
    TaskProcessor taskObject = new BackgroundVerificationTaskProcessor(new DocumentCollectionTaskProcessor
            (new TrackingDeviceShippingTaskProcessor(null)));
    taskObject.execute(taskId, "completed successfully for Driver ID "+ driverId+ " !");
    HashMap<Integer,Boolean> taskWithStatus = driverTaskStatus.get(driverId);
    if(taskWithStatus == null){
      taskWithStatus = new HashMap<>();
    }
    taskWithStatus.put(taskId, true);
    driverTaskStatus.put(driverId, taskWithStatus);

  }

  public void areDriverTasksCompleted(final int driverId){
    HashMap<Integer,Boolean> status = driverTaskStatus.get(driverId);
    int count=0;
    for(int i=1;i<=3;i++){
      if(status!=null && status.get(i)!=null && status.get(i) == true)
        count++;
    }
    if(count == 3){
      System.out.println("Driver has finished the onboarding process. Congratulations!");
    }else {
      System.out.println("Uh, oh! Seems like few tasks are pending, please mark all tasks finished");
    }
  }
}
