package org.example.tasks;

public class DocumentCollectionTaskProcessor extends TaskProcessor{
    public DocumentCollectionTaskProcessor(TaskProcessor nextProcessor){
        super(nextProcessor);
    }
    public void execute(int priorityOrder,String message){

        if(priorityOrder == DOCUMENT_COLLECTION_TASK_ORDER) {
            System.out.println("DOCUMENT_COLLECTION_TASK_STATUS: " + message);
        } else{
            super.execute(priorityOrder, message);
        }

    }

}
