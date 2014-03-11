package ua.org.gostroy.events.photo;

import ua.org.gostroy.events.ReadedEvent;

import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class PhotoDetailEvent extends ReadedEvent {
    private UUID key;
    private PhotoDetails photoDetails;

    public PhotoDetailEvent(UUID key, PhotoDetails photoDetails) {
        this.key = key;
        this.photoDetails = photoDetails;
    }

    public PhotoDetailEvent(UUID key) {
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }

    public PhotoDetails getPhotoDetails() {
        return photoDetails;
    }

    public static PhotoDetailEvent notFound(UUID key){
        PhotoDetailEvent pe = new PhotoDetailEvent(key);
        pe.entityFound = false;
        return pe;
    }
}
