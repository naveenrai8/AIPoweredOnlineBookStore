package dev.nr.onlinebookstore.service;

import dev.nr.onlinebookstore.dto.AuthorResponse;
import dev.nr.onlinebookstore.entity.Author;
import dev.nr.onlinebookstore.exception.AuthorNotFoundException;
import dev.nr.onlinebookstore.mapper.AuthorMapper;
import dev.nr.onlinebookstore.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorResponse getAuthor(Long authorId) throws AuthorNotFoundException {
        Author authorDb = getAuthorById(authorId);
        return this.authorMapper.toResponse(authorDb);
    }

    public boolean authorExists(Long authorId) {
        try {
            Author authorDb = getAuthorById(authorId);
            return !authorDb.isDeleted();

        } catch (AuthorNotFoundException ex) {
            return false;
        }
    }

    private Author getAuthorById(Long authorId) throws AuthorNotFoundException {
        return this.authorRepository.findById(authorId)
                .orElseThrow(() -> AuthorNotFoundException.builder().message("").build());
    }
}
