package org.example.tasks;

public abstract class TaskProcessor {
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
