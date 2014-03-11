package ua.org.gostroy.events.photo;

import ua.org.gostroy.events.ReadEvent;

import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class RequestPhotoDetailEvent extends ReadEvent {
    private UUID key;

    public RequestPhotoDetailEvent(UUID key) {
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }
}
