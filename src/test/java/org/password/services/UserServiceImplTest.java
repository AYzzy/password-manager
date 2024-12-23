package org.password.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.password.data.repository.UserRepo;
import org.password.dtos.request.CreateUserRequest;
import org.password.dtos.response.CreateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp(){
        userRepo.deleteAll();
    }
    
    @Test
    public void testToCreateUser(){
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setUserName("Ayzzy");
        userRequest.setPassword("1235567");
        CreateUserResponse userResponse = userService.createUser(userRequest);
        assertNotNull(userResponse);
        assertThat(userRepo.count(), is(1L));

    }
    @Test
    public void testToValidateThatUsernameCantBeUsedMoreThanOnceToCreateAnAccount(){
        CreateUserRequest userRequest = new CreateUserRequest();
        userRequest.setFirstName("olamide");
        userRequest.setUserName("Ayzzy");
        userRequest.setPassword("1235567");
        CreateUserResponse userResponse = userService.createUser(userRequest);
        assertNotNull(userResponse);
        CreateUserRequest userRequest1 = new CreateUserRequest();
        userRequest1.setFirstName("ola");
        userRequest1.setUserName("Ayzzy");
        userRequest1.setPassword("22334455");
        CreateUserResponse userResponse1 = userService.createUser(userRequest1);
        assertNotNull(userResponse1);
        assertThat(userRepo.count(), is(2L));

    }




}
