package ua.org.gostroy.core.domain;

import ua.org.gostroy.events.photo.PhotoDetails;

import java.util.Date;
import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class Photo {
    private UUID key;
    private Date dateTimeOfRecive;
    private String name;
    private Long size;
    private byte[] image;

    //currently 5 minutes
    private final static long ACCEPT_CANCEL_TIME = 1000 * 60 * 5;

    public Photo(UUID key, Date dateTimeOfRecive, String name, Long size, byte[] image) {
        this.key = key;
        this.dateTimeOfRecive = dateTimeOfRecive;
        this.name = name;
        this.size = size;
        this.image = image;
    }

    public Photo(Date dateTimeOfRecive, String name, Long size, byte[] image) {
        this.dateTimeOfRecive = dateTimeOfRecive;
        this.name = name;
        this.size = size;
        this.image = image;
        key = UUID.randomUUID();
    }

    public Date getDateTimeOfRecive() {
        return dateTimeOfRecive;
    }

    public void setDateTimeOfRecive(Date dateTimeOfRecive) {
        this.dateTimeOfRecive = dateTimeOfRecive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public UUID getKey() {
        return key;
    }

    public PhotoDetails toPhotoDetails(){
        PhotoDetails photoDetails = new PhotoDetails();

        photoDetails.setKey(this.key);
        photoDetails.setDateTimeOfRecive(this.dateTimeOfRecive);
        photoDetails.setName(this.name);
        photoDetails.setSize(this.size);
        photoDetails.setImage(this.image);

        return photoDetails;
    }

    public static Photo fromPhotoDetails(PhotoDetails photoDetails){
        Photo photo = new Photo(photoDetails.getKey(), photoDetails.getDateTimeOfRecive(),
                photoDetails.getName(), photoDetails.getSize(), photoDetails.getImage());

        return photo;
    }

    public boolean canBeDeleted() {
        //accept cancellation if within 5 minutes of placing.
        return System.currentTimeMillis() - dateTimeOfRecive.getTime() < ACCEPT_CANCEL_TIME;
    }

}
