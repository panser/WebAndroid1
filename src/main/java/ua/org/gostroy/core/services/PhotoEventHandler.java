package ua.org.gostroy.core.services;

import ua.org.gostroy.events.photo.*;
import ua.org.gostroy.core.domain.Photo;
import ua.org.gostroy.persistence.services.PhotoPersistenceService;

/**
 * Created by panser on 3/11/14.
 */
public class PhotoEventHandler implements PhotoService {
    private final PhotoPersistenceService photoPersistenceService;

    public PhotoEventHandler(PhotoPersistenceService photoPersistenceService) {
        this.photoPersistenceService = photoPersistenceService;
    }

    @Override
    public AllPhotosEvent requestAllPhotos(RequestAllPhotosEvent requestAllPhotosEvent) {
        return photoPersistenceService.requestAllPhotos(requestAllPhotosEvent);
    }

    @Override
    public PhotoDetailEvent requestPhotoDetail(RequestPhotoDetailEvent requestPhotoDetailEvent) {
        return photoPersistenceService.requestPhotoDetail(requestPhotoDetailEvent);
    }

    @Override
    public CreatedPhotoEvent createPhoto(CreatePhotoEvent createPhotoEvent) {
        Photo photo = Photo.fromPhotoDetails(createPhotoEvent.getPhotoDetails());

        //TODO, add validation of menu items
        //TODO, add order total calculation
        //TODO, add order time estimate calculation

        CreatedPhotoEvent event = photoPersistenceService.createPhoto(createPhotoEvent);
        return event;
    }

    @Override
    public DeletedPhotoEvent deletePhoto(DeletePhotoEvent deletePhotoEvent) {
        PhotoDetailEvent photoDetailEvent = photoPersistenceService.requestPhotoDetail(new RequestPhotoDetailEvent(deletePhotoEvent.getKey()));

        if(!photoDetailEvent.isEntityFount()){
            return DeletedPhotoEvent.notFound(deletePhotoEvent.getKey());
        }

        Photo photo = Photo.fromPhotoDetails(photoDetailEvent.getPhotoDetails());

        if(!photo.canBeDeleted()){
            return DeletedPhotoEvent.deletionForbidden(deletePhotoEvent.getKey(), photo.toPhotoDetails());
        }

        photoPersistenceService.deletePhoto(deletePhotoEvent);

        return new DeletedPhotoEvent(deletePhotoEvent.getKey(), photo.toPhotoDetails());
    }
}
