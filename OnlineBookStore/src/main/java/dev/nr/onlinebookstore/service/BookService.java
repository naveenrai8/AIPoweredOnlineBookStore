package dev.nr.onlinebookstore.service;

import dev.nr.onlinebookstore.dto.BookRequest;
import dev.nr.onlinebookstore.dto.BookResponse;
import dev.nr.onlinebookstore.entity.Book;
import dev.nr.onlinebookstore.exception.BookEntryFailedException;
import dev.nr.onlinebookstore.exception.BookNotFoundException;
import dev.nr.onlinebookstore.exception.PublicationNotFoundException;
import dev.nr.onlinebookstore.mapper.BookMapper;
import dev.nr.onlinebookstore.repository.BookRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final PublicationService publicationService;

    public BookResponse getBook(Long bookId) throws BookNotFoundException {
        final Book book = this.bookRepository
                .findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with Id: %s not found", bookId)));

        var bookResponse = this.bookMapper.toResponse(book);
        log.info("Book from db: {}, Saved book: {}", book, bookResponse);
        return bookResponse;
    }

    public BookResponse addBook(@Valid BookRequest bookRequest) throws BookEntryFailedException, PublicationNotFoundException {
        if (!this.authorService.authorExists(bookRequest.getAuthorId())) {
            String message = String.format("Book with title: %s failed to created due to Author with id: %s not found", bookRequest.getTitle(), bookRequest.getAuthorId());
            log.error(message);
            throw BookEntryFailedException.builder()
                    .message(String.format(message))
                    .build();
        }

        if (!this.publicationService.publicationExists(bookRequest.getPublicationId())) {
            String message = String.format("Book with title: %s failed to created due to Publication with id: %s not found", bookRequest.getTitle(), bookRequest.getPublicationId());
            log.error(message);
            throw BookEntryFailedException.builder()
                    .message(String.format(message))
                    .build();
        }
        Book book = this.bookMapper.toEntity(bookRequest);
        Book savedBook = this.bookRepository.save(book);
        log.info("Book Request: {}, Saved book: {}", book, savedBook);
        return this.bookMapper.toResponse(book);
    }
}
