package dev.nr.onlinebookstore.mapper;

import dev.nr.onlinebookstore.dto.PublicationRequest;
import dev.nr.onlinebookstore.dto.PublicationResponse;
import dev.nr.onlinebookstore.entity.Publication;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface PublicationMapper {

    PublicationResponse toResponse(Publication publication);

    Publication toEntity(PublicationRequest publicationRequest);
}
