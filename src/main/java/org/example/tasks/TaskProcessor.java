package org.example.tasks;

public abstract class TaskProcessor {
    public static int DOCUMENT_COLLECTION_TASK_ORDER = 1;
    public static int BACKGROUND_VERIFICATION_TASK_ORDER = 2;
    public static int TRACKING_DEVICE_SHIPPING_TASK_ORDER = 3;

    TaskProcessor nextTaskProcessor;

    TaskProcessor(TaskProcessor taskProcessor) {

        this.nextTaskProcessor = taskProcessor;

    }

    public void execute(int priorityOrder, String message) {
        if (nextTaskProcessor != null) {
            nextTaskProcessor.execute(priorityOrder, message);
        }
    }

}
