package dev.nr.onlinebookstore.bookservice.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String format) {
        super(format);
    }
}
