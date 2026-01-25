package dev.nr.onlinebookstore.mapper;

import dev.nr.onlinebookstore.dto.PublicationRequest;
import dev.nr.onlinebookstore.dto.PublicationResponse;
import dev.nr.onlinebookstore.entity.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PublicationMapper {

    PublicationResponse toResponse(Publication publication);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    Publication toEntity(PublicationRequest publicationRequest);

    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void toUpdate(PublicationRequest publicationRequest, @MappingTarget Publication publication);
}
