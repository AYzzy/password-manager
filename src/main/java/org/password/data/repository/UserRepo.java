package org.password.data.repository;

import org.password.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
    User findByUserNameIgnoreCase(String username);

}
