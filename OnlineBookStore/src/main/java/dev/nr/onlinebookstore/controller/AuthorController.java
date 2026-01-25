package dev.nr.onlinebookstore.controller;

import dev.nr.onlinebookstore.dto.AuthorRequest;
import dev.nr.onlinebookstore.dto.AuthorResponse;
import dev.nr.onlinebookstore.exception.AuthorNotFoundException;
import dev.nr.onlinebookstore.markers.OnUpdate;
import dev.nr.onlinebookstore.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/author/")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthor(@PathVariable("id") Long authorId) throws AuthorNotFoundException {
        return ResponseEntity.ok(this.authorService.getAuthor(authorId));
    }

    @PostMapping
    public ResponseEntity<AuthorResponse> addAuthor(@Valid @RequestBody AuthorRequest authorRequest) {
        return ResponseEntity.ok(this.authorService.addAuthor(authorRequest));
    }

    @PutMapping
    public ResponseEntity<AuthorResponse> updateBook(@Validated(OnUpdate.class) @RequestBody AuthorRequest authorRequest) throws AuthorNotFoundException {
        return ResponseEntity.ok(this.authorService.updateAuthor(authorRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") Long authorId) throws AuthorNotFoundException {
        this.authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }
}
