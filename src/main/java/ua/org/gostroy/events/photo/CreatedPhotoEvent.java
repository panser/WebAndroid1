package ua.org.gostroy.events.photo;

import ua.org.gostroy.events.CreatedEvent;

import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class CreatedPhotoEvent extends CreatedEvent{
    private final UUID newKey;
    private final PhotoDetails newPhotoDetails;

    public CreatedPhotoEvent(UUID newKey, PhotoDetails newPhotoDetails) {
        this.newKey = newKey;
        this.newPhotoDetails = newPhotoDetails;
    }

    public UUID getNewKey() {
        return newKey;
    }

    public PhotoDetails getNewPhotoDetails() {
        return newPhotoDetails;
    }
}
