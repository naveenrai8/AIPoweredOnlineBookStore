package dev.nr.onlinebookstore.service;

import dev.nr.onlinebookstore.dto.PublicationRequest;
import dev.nr.onlinebookstore.dto.PublicationResponse;
import dev.nr.onlinebookstore.entity.Publication;
import dev.nr.onlinebookstore.exception.PublicationNotFoundException;
import dev.nr.onlinebookstore.mapper.PublicationMapper;
import dev.nr.onlinebookstore.repository.PublicationRepository;
import jakarta.validation.Valid;
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
        return !publication.isDeleted();
    }

    public Publication getPublicationById(Long publicationId) throws PublicationNotFoundException {
        return this.publicationRepository.findById(publicationId)
                .orElseThrow(() -> PublicationNotFoundException.builder()
                        .message(String.format("Publication with id: %s not found.", publicationId))
                        .build());
    }

    public PublicationResponse addPublication(@Valid PublicationRequest publicationRequest) {
        Publication publication = this.publicationMapper.toEntity(publicationRequest);
        Publication publicationDb = this.publicationRepository.save(publication);
        return this.publicationMapper.toResponse(publicationDb);
    }

    public PublicationResponse updatePublication(PublicationRequest publicationRequest) throws PublicationNotFoundException {
        final Publication publicationDb = getPublicationById(publicationRequest.getId());
        this.publicationMapper.toUpdate(publicationRequest, publicationDb);
        this.publicationRepository.save(publicationDb);
        return this.publicationMapper.toResponse(publicationDb);
    }

    public void deletePublication(Long publicationId) throws PublicationNotFoundException {
        final Publication publicationDb = getPublicationById(publicationId);
        publicationDb.setDeleted(true);
        this.publicationRepository.save(publicationDb);

    }
}
