package org.example.tasks;

import org.example.model.Task;

public class BackgroundVerificationTaskProcessor extends TaskProcessor{
    public BackgroundVerificationTaskProcessor(TaskProcessor nextProcessor){
        super(nextProcessor);
    }
    public void execute(int priorityOrder,String message){

        if(priorityOrder == Task.BACKGROUND_VERIFICATION_TASK.value) {
            System.out.println("BACKGROUND_VERIFICATION_TASK_STATUS: " + message);
        } else{
            super.execute(priorityOrder, message);
        }

    }
}
