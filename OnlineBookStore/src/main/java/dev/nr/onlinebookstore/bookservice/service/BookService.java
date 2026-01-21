package dev.nr.onlinebookstore.bookservice.service;

import dev.nr.onlinebookstore.bookservice.dto.BookRequest;
import dev.nr.onlinebookstore.bookservice.dto.BookResponse;
import dev.nr.onlinebookstore.bookservice.entity.Book;
import dev.nr.onlinebookstore.bookservice.exception.BookNotFoundException;
import dev.nr.onlinebookstore.bookservice.mapper.BookMapper;
import dev.nr.onlinebookstore.bookservice.repository.BookRepository;
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

    public BookResponse getBook(Long bookId) throws BookNotFoundException {
        final Book book = this.bookRepository
                .findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(String.format("Book with Id: %s not found", bookId)));

        var bookResponse = this.bookMapper.toResponse(book);
        log.info("Book from db: {}, Saved book: {}", book, bookResponse);
        return bookResponse;
    }

    public BookResponse addBook(@Valid BookRequest bookRequest) {
        Book book = this.bookMapper.toEntity(bookRequest);
        Book savedBook = this.bookRepository.save(book);
        log.info("Book Request: {}, Saved book: {}", book, savedBook);
        return this.bookMapper.toResponse(book);
    }
}
