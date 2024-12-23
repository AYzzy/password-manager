package org.password.data.repository;

import org.password.data.models.PasswordVault;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PasswordVaultRepo extends MongoRepository<PasswordVault,String> {
}
