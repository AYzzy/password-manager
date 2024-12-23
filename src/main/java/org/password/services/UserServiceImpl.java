package org.password.services;

import org.password.data.models.User;
import org.password.data.repository.UserRepo;
import org.password.dtos.request.CreateUserRequest;
import org.password.dtos.request.UpdateUserRequest;
import org.password.dtos.response.CreateUserResponse;
import org.password.dtos.response.UpdateUserResponse;
import org.password.exception.UserAlreadyInExistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest update) {
        User user = userRepo.findUserById(update.getId());
        updateRequirement(user, update);
        userRepo.save(user);
        UpdateUserResponse response = new UpdateUserResponse();
        response.setMessage("Update Successful");
        return response;
    }
    private void updateRequirement(User user, UpdateUserRequest update){
        user.setUserName(update.getUserName().toLowerCase().strip());
        user.setPassword(update.getPassword());
    }

    private void userRequirement(User user,CreateUserRequest userRequest){
        validateUserName(userRequest.getUserName());
        user.setName(userRequest.getFirstName());
        user.setUserName(userRequest.getUserName().toLowerCase().strip());
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
    }

    private void validateUserName(String userName) {
        if(userRepo.findByUserNameIgnoreCase(userName)!=null)
            throw new UserAlreadyInExistence("User already exist");
    }

    private CreateUserResponse userRequirementResponse(User user){
        CreateUserResponse response=new CreateUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setMessage("You have successfully registered");
        return response;

    }

}
