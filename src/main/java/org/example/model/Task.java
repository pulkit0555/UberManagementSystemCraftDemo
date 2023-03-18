package org.example.model;

public enum Task {
    TRACKING_DEVICE_SHIPPING_TASK(3),
    DOCUMENT_COLLECTION_TASK(2),
    BACKGROUND_VERIFICATION_TASK(1);

    public final Integer value;

    private Task(Integer value) {
        this.value = value;
    }
}
