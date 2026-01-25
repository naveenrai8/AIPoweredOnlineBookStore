package dev.nr.onlinebookstore.mapper;

import dev.nr.onlinebookstore.dto.AuthorRequest;
import dev.nr.onlinebookstore.dto.AuthorResponse;
import dev.nr.onlinebookstore.entity.Author;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AuthorMapper {

    AuthorResponse toResponse(Author author);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Author toEntity(AuthorRequest authorRequest);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void toUpdate(AuthorRequest authorRequest, @MappingTarget Author author);
}
