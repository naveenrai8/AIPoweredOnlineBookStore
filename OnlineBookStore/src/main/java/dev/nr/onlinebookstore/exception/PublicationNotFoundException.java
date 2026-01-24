package dev.nr.onlinebookstore.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PublicationNotFoundException extends Exception {

    @Builder
    public PublicationNotFoundException(String message) {
        super(message);
    }
}
