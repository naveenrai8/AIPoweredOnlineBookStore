package dev.nr.onlinebookstore.mapper;

import dev.nr.onlinebookstore.entity.Author;
import dev.nr.onlinebookstore.dto.AuthorResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AuthorMapper {

    AuthorResponse toResponse(Author author);
}
