package dev.nr.onlinebookstore.controller;

import dev.nr.onlinebookstore.dto.PublicationResponse;
import dev.nr.onlinebookstore.exception.PublicationNotFoundException;
import dev.nr.onlinebookstore.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/publication/")
@RequiredArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;

    @GetMapping("/{id}")
    public ResponseEntity<PublicationResponse> getPublication(@PathVariable("id") Long publicationId) throws PublicationNotFoundException {
        return ResponseEntity.ok(this.publicationService.getPublication(publicationId));
    }
}
