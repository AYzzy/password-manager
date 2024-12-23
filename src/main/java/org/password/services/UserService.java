package org.password.services;

import org.password.dtos.request.CreateUserRequest;
import org.password.dtos.request.UpdateUserRequest;
import org.password.dtos.response.CreateUserResponse;
import org.password.dtos.response.UpdateUserResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest userRequest);
    UpdateUserResponse updateUser(UpdateUserRequest update);
}
