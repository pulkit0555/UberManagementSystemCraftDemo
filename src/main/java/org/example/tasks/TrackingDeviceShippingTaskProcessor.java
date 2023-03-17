package org.example.tasks;

public class TrackingDeviceShippingTaskProcessor extends TaskProcessor {
    public TrackingDeviceShippingTaskProcessor(TaskProcessor nextProcessor){
        super(nextProcessor);
    }
    public void execute(int priorityOrder,String message){

        if(priorityOrder == TRACKING_DEVICE_SHIPPING_TASK_ORDER) {
            System.out.println("TRACKING_DEVICE_SHIPPING_TASK_STATUS: " + message);
        } else{
            super.execute(priorityOrder, message);
        }

    }
}
