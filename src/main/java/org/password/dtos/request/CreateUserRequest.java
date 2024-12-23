package org.password.dtos.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String id;
    private String firstName;
    private String userName;
    private String password;
    private String email;
}
