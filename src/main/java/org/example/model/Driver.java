package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.tasks.TaskProcessor;

@AllArgsConstructor
public class Driver {

  private final String name;

  @Getter private int id;

  @Getter @Setter private Integer mobileNumber;

  @Getter @Setter private String email;

  //considering cases where renewal changes DL number
  @Getter @Setter private String drivingLicenseNumber;

  @Getter @Setter private Trip currentTrip;

  @Setter private boolean isAcceptingRider;

  @Getter @Setter private TaskProcessor taskProcessor;

  public Driver(int id, String name, Integer mobileNumber, String email, String dlNumber) {
    this.id = id;
    this.name = name;
    this.mobileNumber = mobileNumber;
    this.email = email;
    this.drivingLicenseNumber = dlNumber;
    this.isAcceptingRider = true;
  }

  /**
   * Helper method to check whether driver can take new riders or not.
   *
   * @return
   */
  public boolean isAvailable() {
    return this.isAcceptingRider && this.currentTrip == null;
  }

}
