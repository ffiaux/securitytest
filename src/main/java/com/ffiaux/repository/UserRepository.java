package com.ffiaux.repository;

import com.ffiaux.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ffiaux on 27/05/2016.
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
}
