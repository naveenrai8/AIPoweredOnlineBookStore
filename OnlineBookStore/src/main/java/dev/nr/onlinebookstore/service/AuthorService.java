package dev.nr.onlinebookstore.service;

import dev.nr.onlinebookstore.dto.AuthorRequest;
import dev.nr.onlinebookstore.dto.AuthorResponse;
import dev.nr.onlinebookstore.entity.Author;
import dev.nr.onlinebookstore.exception.AuthorNotFoundException;
import dev.nr.onlinebookstore.mapper.AuthorMapper;
import dev.nr.onlinebookstore.repository.AuthorRepository;
import jakarta.validation.Valid;
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
                .orElseThrow(() -> AuthorNotFoundException.builder()
                        .message(String.format("Author id: %s not found", authorId))
                        .build());
    }

    public AuthorResponse addAuthor(@Valid AuthorRequest authorRequest) {
        Author author = this.authorMapper.toEntity(authorRequest);
        Author authorDb = this.authorRepository.save(author);
        return this.authorMapper.toResponse(authorDb);
    }

    public AuthorResponse updateAuthor(AuthorRequest authorRequest) throws AuthorNotFoundException {
        final Author authorDb = getAuthorById(authorRequest.getId());
        this.authorMapper.toUpdate(authorRequest, authorDb);
        this.authorRepository.save(authorDb);
        return this.authorMapper.toResponse(authorDb);
    }

    public void deleteAuthor(Long authorId) throws AuthorNotFoundException {
        final Author authorDb = getAuthorById(authorId);
        authorDb.setDeleted(true);
        this.authorRepository.save(authorDb);

    }
}
