package it.hacksociety.middleware.hsmiddleware.repository;

import it.hacksociety.middleware.hsmiddleware.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByName(String name);
}
