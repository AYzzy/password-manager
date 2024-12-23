package org.password.dtos.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String id;
    private String userName;
    private String password;
}
