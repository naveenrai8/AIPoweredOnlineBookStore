package dev.nr.onlinebookstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> bookNotFoundException(BookNotFoundException bookNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bookNotFoundException.getMessage());
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public ResponseEntity<String> authorNotFoundException(AuthorNotFoundException authorNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(authorNotFoundException.getMessage());
    }

    @ExceptionHandler(PublicationNotFoundException.class)
    public ResponseEntity<String> publicationNotFoundException(PublicationNotFoundException publicationNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(publicationNotFoundException.getMessage());
    }
}
