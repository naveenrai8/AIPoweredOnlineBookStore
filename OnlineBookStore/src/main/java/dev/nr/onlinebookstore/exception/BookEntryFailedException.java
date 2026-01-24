package dev.nr.onlinebookstore.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BookEntryFailedException extends Exception {

    @Builder
    public BookEntryFailedException(String message) {
        super(message);
    }
}
