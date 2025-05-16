package com.codequest.backend.repository;

import com.codequest.backend.entity.Profile;
import com.codequest.backend.entity.User;
import org.bson.types.ObjectId;
//import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile, ObjectId> {
    Optional<Profile> findByUsername(String username);

    Optional<Profile> findByEmail(String username);
}

