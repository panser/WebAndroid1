package ua.org.gostroy.persistence.domain;

import ua.org.gostroy.events.photo.PhotoDetails;

import java.util.Date;
import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class Photo {
    private String id;
    private Date dateTimeOfRecive;
    private String name;
    private Long size;
    private byte[] image;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PhotoDetails toPhotoDetails(){
        PhotoDetails photoDetails = new PhotoDetails();

        photoDetails.setKey(UUID.fromString(this.id));
        photoDetails.setDateTimeOfRecive(this.dateTimeOfRecive);
        photoDetails.setName(this.name);
        photoDetails.setSize(this.size);
        photoDetails.setImage(this.image);

        return photoDetails;
    }

    public static Photo fromPhotoDetails(PhotoDetails photoDetails){
        Photo photo = new Photo();
        photo.id = photoDetails.getKey().toString();
        photo.dateTimeOfRecive = photoDetails.getDateTimeOfRecive();
        photo.name = photoDetails.getName();
        photo.size = photoDetails.getSize();
        photo.image = photoDetails.getImage();

        return photo;
    }
}
