package org.example.tasks;

import org.example.model.Task;

public class DocumentCollectionTaskProcessor extends TaskProcessor{
    public DocumentCollectionTaskProcessor(TaskProcessor nextProcessor){
        super(nextProcessor);
    }
    public void execute(int priorityOrder,String message){

        if(priorityOrder == Task.DOCUMENT_COLLECTION_TASK.value) {
            System.out.println("DOCUMENT_COLLECTION_TASK_STATUS: " + message);
        } else{
            super.execute(priorityOrder, message);
        }

    }

}
