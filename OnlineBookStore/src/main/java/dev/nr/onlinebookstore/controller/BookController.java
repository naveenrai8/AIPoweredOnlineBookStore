package dev.nr.onlinebookstore.controller;

import dev.nr.onlinebookstore.dto.BookRequest;
import dev.nr.onlinebookstore.dto.BookResponse;
import dev.nr.onlinebookstore.exception.BookEntryFailedException;
import dev.nr.onlinebookstore.exception.BookNotFoundException;
import dev.nr.onlinebookstore.exception.PublicationNotFoundException;
import dev.nr.onlinebookstore.markers.OnCreate;
import dev.nr.onlinebookstore.markers.OnUpdate;
import dev.nr.onlinebookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBook(@Validated(OnCreate.class) @PathVariable("id") Long bookId) throws BookNotFoundException {
        return ResponseEntity.ok(this.bookService.getBook(bookId));
    }

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody BookRequest bookRequest) throws BookEntryFailedException, PublicationNotFoundException {
        return ResponseEntity.ok(this.bookService.addBook(bookRequest));
    }

    @PutMapping
    public ResponseEntity<BookResponse> updateBook(@Validated(OnUpdate.class) @RequestBody BookRequest bookRequest) throws BookEntryFailedException, BookNotFoundException, PublicationNotFoundException {
        return ResponseEntity.ok(this.bookService.updateBook(bookRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long bookId) throws BookNotFoundException {
        this.bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
