package ua.org.gostroy.events.photo;

import ua.org.gostroy.events.CreateEvent;

/**
 * Created by panser on 3/11/14.
 */
public class CreatePhotoEvent extends CreateEvent {
    private PhotoDetails photoDetails;

    public CreatePhotoEvent(PhotoDetails photoDetails) {
        this.photoDetails = photoDetails;
    }

    public PhotoDetails getPhotoDetails() {
        return photoDetails;
    }
}
