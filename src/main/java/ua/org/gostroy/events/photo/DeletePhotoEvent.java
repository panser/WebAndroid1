package ua.org.gostroy.events.photo;

import ua.org.gostroy.events.DeleteEvent;

import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class DeletePhotoEvent extends DeleteEvent {
    private final UUID key;

    public DeletePhotoEvent(UUID key) {
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }
}
