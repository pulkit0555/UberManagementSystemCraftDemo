package org.example;

import org.example.manager.DriverManager;
import org.example.model.Driver;
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
        driverManager.executeTasks(1, TaskProcessor.TRACKING_DEVICE_SHIPPING_TASK_ORDER);
        driverManager.executeTasks(2, TaskProcessor.DOCUMENT_COLLECTION_TASK_ORDER);
        driverManager.areDriverTasksCompleted(1);
        driverManager.executeTasks(1, TaskProcessor.DOCUMENT_COLLECTION_TASK_ORDER);
        driverManager.executeTasks(1, TaskProcessor.BACKGROUND_VERIFICATION_TASK_ORDER);
        driverManager.areDriverTasksCompleted(1);
        driverManager.executeTasks(1, 100);


    }
}