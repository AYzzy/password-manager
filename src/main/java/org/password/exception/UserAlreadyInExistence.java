package org.password.exception;

public class UserAlreadyInExistence extends RuntimeException {
    public UserAlreadyInExistence(String message) {
        super(message);
    }
}
