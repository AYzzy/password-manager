package org.password.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data

public class User {
    @Id
    private String Id;
    private String name;
    private String userName;
    private String password;
}
