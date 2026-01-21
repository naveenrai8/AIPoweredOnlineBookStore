package dev.nr.onlinebookstore.bookservice.exception;

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
}
