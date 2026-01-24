package dev.nr.onlinebookstore.service;

import dev.nr.onlinebookstore.dto.PublicationResponse;
import dev.nr.onlinebookstore.entity.Publication;
import dev.nr.onlinebookstore.exception.PublicationNotFoundException;
import dev.nr.onlinebookstore.mapper.PublicationMapper;
import dev.nr.onlinebookstore.repository.PublicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final PublicationMapper publicationMapper;

    public PublicationResponse getPublication(Long publicationId) throws PublicationNotFoundException {
        Publication publicationDb = getPublicationById(publicationId);
        return this.publicationMapper.toResponse(publicationDb);
    }

    public boolean publicationExists(Long publicationId) throws PublicationNotFoundException {
        Publication publication = getPublicationById(publicationId);
        return !publication.isDelete();
    }

    public Publication getPublicationById(Long publicationId) throws PublicationNotFoundException {
        return this.publicationRepository.findById(publicationId)
                .orElseThrow(() -> PublicationNotFoundException.builder()
                        .message(String.format("Publication with id: %s not found.", publicationId))
                        .build());
    }
}
