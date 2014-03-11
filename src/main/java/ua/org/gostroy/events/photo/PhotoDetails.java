package ua.org.gostroy.events.photo;

import java.util.Date;
import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class PhotoDetails {
    private UUID key;
    private Date dateTimeOfRecive;
    private String name;
    private Long size;
    private Object image;

    public PhotoDetails(UUID key) {
        this.key = key;
    }

    public PhotoDetails() {
        key = null;
    }

    public UUID getKey() {
        return key;
    }

    public void setKey(UUID key) {
        this.key = key;
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

    public void setImage(Object image) {
        this.image = image;
    }
}
