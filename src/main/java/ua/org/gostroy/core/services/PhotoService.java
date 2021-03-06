package ua.org.gostroy.core.services;

import ua.org.gostroy.events.photo.*;

/**
 * Created by panser on 3/11/14.
 */
public interface PhotoService {
    public AllPhotosEvent requestAllPhotos(RequestAllPhotosEvent requestAllPhotosEvent);
    public PhotoDetailEvent requestPhotoDetail(RequestPhotoDetailEvent requestPhotoDetailEvent);
    public CreatedPhotoEvent createPhoto(CreatePhotoEvent createPhotoEvent);
    public DeletedPhotoEvent deletePhoto(DeletePhotoEvent deletePhotoEvent);
}
