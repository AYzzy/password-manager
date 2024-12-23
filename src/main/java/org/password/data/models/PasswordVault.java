package org.password.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;
@Data
public class PasswordVault {
    @Id
    private String vaultId;
    private String encryptionKey;
    @DBRef
    private List<PasswordEntry> entryList = new ArrayList<>();

}
