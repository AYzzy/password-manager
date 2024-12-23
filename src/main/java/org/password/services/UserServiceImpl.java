package org.password.services;

import org.password.data.models.User;
import org.password.data.repository.UserRepo;
import org.password.dtos.request.CreateUserRequest;
import org.password.dtos.response.CreateUserResponse;
import org.password.exception.UserAlreadyInExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepo userRepo;
    @Override
    public CreateUserResponse createUser(CreateUserRequest userRequest) {
        User user = new User();
        userRequirement(user ,userRequest);
        user = userRepo.save(user);
        return userRequirementResponse(user);
    }

    private void userRequirement(User user,CreateUserRequest userRequest){
        validateUserName(userRequest.getUserName());
        user.setName(userRequest.getFirstName());
        user.setUserName(userRequest.getUserName().toLowerCase().strip());
        user.setPassword(userRequest.getPassword());
    }

    private void validateUserName(String userName) {
        if(userRepo.findByUserNameIgnoreCase(userName).equals(userName))
            throw new UserAlreadyInExistence("User already exist");
    }

    private CreateUserResponse userRequirementResponse(User user){
        CreateUserResponse response=new CreateUserResponse();
        response.setName(user.getName());
        response.setMessage("You have successfully registered");
        return response;

    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }
}
