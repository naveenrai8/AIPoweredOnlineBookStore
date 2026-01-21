package dev.nr.onlinebookstore.bookservice.mapper;

import dev.nr.onlinebookstore.bookservice.dto.BookRequest;
import dev.nr.onlinebookstore.bookservice.dto.BookResponse;
import dev.nr.onlinebookstore.bookservice.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BookMapper {

    BookResponse toResponse(Book book);

    Book toEntity(BookRequest bookRequest);
}
