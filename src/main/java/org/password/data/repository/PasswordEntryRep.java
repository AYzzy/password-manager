package org.password.data.repository;

import org.password.data.models.PasswordEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordEntryRep extends MongoRepository<PasswordEntry, String> {
}
