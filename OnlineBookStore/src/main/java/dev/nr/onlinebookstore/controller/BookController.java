package dev.nr.onlinebookstore.controller;

import dev.nr.onlinebookstore.dto.BookRequest;
import dev.nr.onlinebookstore.dto.BookResponse;
import dev.nr.onlinebookstore.exception.BookEntryFailedException;
import dev.nr.onlinebookstore.exception.BookNotFoundException;
import dev.nr.onlinebookstore.exception.PublicationNotFoundException;
import dev.nr.onlinebookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@PathVariable("id") Long bookId) throws BookNotFoundException {
        return ResponseEntity.ok(this.bookService.getBook(bookId));
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest) throws BookEntryFailedException, PublicationNotFoundException {
        return ResponseEntity.ok(this.bookService.addBook(bookRequest));
    }

}
