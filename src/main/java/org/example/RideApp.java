package org.example;

import org.example.manager.DriverManager;
import org.example.model.Driver;
import org.example.model.Task;
import org.example.tasks.BackgroundVerificationTaskProcessor;
import org.example.tasks.DocumentCollectionTaskProcessor;
import org.example.tasks.TaskProcessor;
import org.example.tasks.TrackingDeviceShippingTaskProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RideApp {
    public static void main(String[] args) {
        //SpringApplication.run(RideApp.class, args);
        DriverManager driverManager = new DriverManager();
        driverManager.createDriver(new Driver(1, "Amar",918171651, "d1@gmail.com", "DL123"));
        driverManager.createDriver(new Driver(2, "Prateek",918171651, "d1@gmail.com", "DL123"));
        driverManager.executeTasks(1, Task.TRACKING_DEVICE_SHIPPING_TASK.value);
        driverManager.executeTasks(2, Task.DOCUMENT_COLLECTION_TASK.value);
        driverManager.areDriverTasksCompleted(2);
        driverManager.executeTasks(1, Task.DOCUMENT_COLLECTION_TASK.value);
        driverManager.executeTasks(1, Task.BACKGROUND_VERIFICATION_TASK.value);
        driverManager.areDriverTasksCompleted(1);
        //driverManager.executeTasks(1, 100);


    }
}