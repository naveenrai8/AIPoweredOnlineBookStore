package dev.nr.onlinebookstore.controller;

import dev.nr.onlinebookstore.dto.AuthorResponse;
import dev.nr.onlinebookstore.exception.AuthorNotFoundException;
import dev.nr.onlinebookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/author/")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> getAuthor(@PathVariable("id") Long authorId) throws AuthorNotFoundException {
        return ResponseEntity.ok(this.authorService.getAuthor(authorId));
    }
}
