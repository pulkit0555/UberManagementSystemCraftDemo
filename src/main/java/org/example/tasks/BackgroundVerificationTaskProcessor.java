package org.example.tasks;

public class BackgroundVerificationTaskProcessor extends TaskProcessor{
    public BackgroundVerificationTaskProcessor(TaskProcessor nextProcessor){
        super(nextProcessor);
    }
    public void execute(int priorityOrder,String message){

        if(priorityOrder == BACKGROUND_VERIFICATION_TASK_ORDER) {
            System.out.println("BACKGROUND_VERIFICATION_TASK_STATUS: " + message);
        } else{
            super.execute(priorityOrder, message);
        }

    }
}
