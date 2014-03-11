package ua.org.gostroy.events.photo;

import ua.org.gostroy.events.ReadedEvent;

import java.util.Collection;
import java.util.List;

/**
 * Created by panser on 3/11/14.
 */
public class AllPhotosEvent extends ReadedEvent {
    private final List<PhotoDetails> photoDetails;

    public AllPhotosEvent(List<PhotoDetails> photoDetailsList) {
        this.photoDetails = photoDetailsList;
    }

    public Collection<PhotoDetails> getPhotoDetailsList() {
        return photoDetails;
    }
}
