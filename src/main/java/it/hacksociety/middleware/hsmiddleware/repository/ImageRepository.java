package it.hacksociety.middleware.hsmiddleware.repository;

import it.hacksociety.middleware.hsmiddleware.model.Image;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image,String> {
    Image findTopByOrderByCreatedDesc();
}
