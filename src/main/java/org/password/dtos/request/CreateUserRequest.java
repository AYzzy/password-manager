package org.password.dtos.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String Id;
    private String firstName;
    private String userName;
    private String password;
}
