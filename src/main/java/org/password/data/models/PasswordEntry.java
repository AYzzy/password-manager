package org.password.data.models;

import lombok.Data;

@Data
public class PasswordEntry {
    private String website;
    private String userName;
    private String password;

}
