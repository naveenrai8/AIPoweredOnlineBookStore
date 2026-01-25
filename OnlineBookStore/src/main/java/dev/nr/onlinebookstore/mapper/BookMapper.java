package dev.nr.onlinebookstore.mapper;

import dev.nr.onlinebookstore.dto.BookRequest;
import dev.nr.onlinebookstore.dto.BookResponse;
import dev.nr.onlinebookstore.entity.Book;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface BookMapper {


    BookResponse toResponse(Book book);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Book toEntity(BookRequest bookRequest);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void toUpdate(BookRequest bookRequest, @MappingTarget Book book);
}
