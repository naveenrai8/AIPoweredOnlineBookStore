package dev.nr.onlinebookstore.exception;

public class BookNotFoundException extends Exception {
    public BookNotFoundException(String format) {
        super(format);
    }
}
