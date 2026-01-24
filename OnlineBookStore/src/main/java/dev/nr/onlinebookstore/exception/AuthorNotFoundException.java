package dev.nr.onlinebookstore.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AuthorNotFoundException extends Exception {

    @Builder
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
