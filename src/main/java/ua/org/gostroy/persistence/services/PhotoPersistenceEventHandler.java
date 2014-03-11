package ua.org.gostroy.persistence.services;

import ua.org.gostroy.events.photo.*;
import ua.org.gostroy.persistence.domain.Photo;
import ua.org.gostroy.persistence.repository.PhotosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by panser on 3/11/14.
 */
public class PhotoPersistenceEventHandler implements PhotoPersistenceService {
    private final PhotosRepository photosRepository;

    public PhotoPersistenceEventHandler(PhotosRepository photosRepository) {
        this.photosRepository = photosRepository;
    }

    @Override
    public AllPhotosEvent requestAllPhotos(RequestAllPhotosEvent requestAllPhotosEvent) {
        List<PhotoDetails> generatedDetails = new ArrayList<PhotoDetails>();
        for(Photo photo : photosRepository.findAll()){
            generatedDetails.add(photo.toPhotoDetails());
        }
        return new AllPhotosEvent(generatedDetails);
    }

    @Override
    public PhotoDetailEvent requestPhotoDetail(RequestPhotoDetailEvent requestPhotoDetailEvent) {
        Photo photo = photosRepository.findOne(requestPhotoDetailEvent.getKey().toString());
        if(photo == null){
            return PhotoDetailEvent.notFound(requestPhotoDetailEvent.getKey());
        }
        return new PhotoDetailEvent(requestPhotoDetailEvent.getKey(), photo.toPhotoDetails());
    }

    @Override
    public CreatedPhotoEvent createPhoto(CreatePhotoEvent createPhotoEvent) {
        Photo photo = Photo.fromPhotoDetails(createPhotoEvent.getPhotoDetails());
        photo = photosRepository.save(photo);
        return new CreatedPhotoEvent(UUID.fromString(photo.getId()),photo.toPhotoDetails());
    }

    @Override
    public DeletedPhotoEvent deletePhoto(DeletePhotoEvent deletePhotoEvent) {
        Photo photo = photosRepository.findOne(deletePhotoEvent.getKey().toString());

        if(photo == null){
            return DeletedPhotoEvent.notFound(deletePhotoEvent.getKey());
        }

        photosRepository.delete(deletePhotoEvent.getKey().toString());
        return new DeletedPhotoEvent(deletePhotoEvent.getKey(), photo.toPhotoDetails());
    }
}
