package org.password.services;

import org.password.data.models.User;
import org.password.dtos.request.CreateUserRequest;
import org.password.dtos.response.CreateUserResponse;

import java.util.List;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest userRequest);
    List<User>getAllUser();
}
