package ua.org.gostroy.events.photo;

import ua.org.gostroy.events.DeletedEvent;

import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class DeletedPhotoEvent extends DeletedEvent {
    private UUID key;
    private PhotoDetails photoDetails;
    private boolean deletionCompleted;

    public DeletedPhotoEvent(UUID key) {
        this.key = key;
    }

    public DeletedPhotoEvent(UUID key, PhotoDetails photoDetails) {
        this.key = key;
        this.photoDetails = photoDetails;
        deletionCompleted = true;
    }

    public UUID getKey() {
        return key;
    }

    public PhotoDetails getPhotoDetails() {
        return photoDetails;
    }

    public boolean isDeletionCompleted() {
        return deletionCompleted;
    }

    public static DeletedPhotoEvent deletionForbidden(UUID key, PhotoDetails photoDetails){
        DeletedPhotoEvent pe = new DeletedPhotoEvent(key, photoDetails);
        pe.entityFound = true;
        pe.deletionCompleted = false;
        return  pe;
    }

    public static DeletedPhotoEvent notFound(UUID key){
        DeletedPhotoEvent pe = new DeletedPhotoEvent(key);
        pe.entityFound = false;
        return pe;
    }
}
