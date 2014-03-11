package ua.org.gostroy.persistence.repository;

import ua.org.gostroy.persistence.domain.Photo;

/**
 * Created by panser on 3/11/14.
 */
public interface PhotosRepository {
    void delete(String key);
    Photo findOne(String key);
    Iterable<Photo> findAll();
    Photo save(Photo photo);
}
