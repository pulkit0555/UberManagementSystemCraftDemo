package org.example.model;

public enum TaskName {
    TRACKING_DEVICE_SHIPPING_TASK("TRACKING_DEVICE_SHIPPING_TASK"),
    DOCUMENT_COLLECTION_TASK("DOCUMENT_COLLECTION_TASK"),
    BACKGROUND_VERIFICATION_TASK("BACKGROUND_VERIFICATION_TASK");

    public final String value;

    private TaskName(String value) {
        this.value = value;
    }
}
