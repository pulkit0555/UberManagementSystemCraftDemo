package org.example.tasks;

import org.example.model.Task;

public class TrackingDeviceShippingTaskProcessor extends TaskProcessor {
    public TrackingDeviceShippingTaskProcessor(TaskProcessor nextProcessor){
        super(nextProcessor);
    }
    public void execute(int priorityOrder,String message){

        if(priorityOrder == Task.TRACKING_DEVICE_SHIPPING_TASK.value) {
            System.out.println("TRACKING_DEVICE_SHIPPING_TASK_STATUS: " + message);
        } else{
            super.execute(priorityOrder, message);
        }

    }
}
