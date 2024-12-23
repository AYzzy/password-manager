package org.password.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class PasswordEntry {
    private String website;
    private String userName;
    private String password;

}
