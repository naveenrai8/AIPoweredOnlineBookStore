package dev.nr.onlinebookstore.mapper;

import dev.nr.onlinebookstore.dto.BookRequest;
import dev.nr.onlinebookstore.dto.BookResponse;
import dev.nr.onlinebookstore.entity.Book;
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
