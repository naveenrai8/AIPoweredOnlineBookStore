package dev.nr.onlinebookstore.controller;

import dev.nr.onlinebookstore.dto.PublicationRequest;
import dev.nr.onlinebookstore.dto.PublicationResponse;
import dev.nr.onlinebookstore.exception.PublicationNotFoundException;
import dev.nr.onlinebookstore.markers.OnUpdate;
import dev.nr.onlinebookstore.service.PublicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/publication/")
@RequiredArgsConstructor
public class PublicationController {

    private final PublicationService publicationService;

    @GetMapping("/{id}")
    public ResponseEntity<PublicationResponse> getPublication(@PathVariable("id") Long publicationId) throws PublicationNotFoundException {
        return ResponseEntity.ok(this.publicationService.getPublication(publicationId));
    }

    @PostMapping
    public ResponseEntity<PublicationResponse> addPublication(@Valid @RequestBody PublicationRequest publicationRequest) {
        return ResponseEntity.ok(this.publicationService.addPublication(publicationRequest));
    }

    @PutMapping
    public ResponseEntity<PublicationResponse> updatePublication(@Validated(OnUpdate.class) @RequestBody PublicationRequest publicationRequest) throws PublicationNotFoundException {
        return ResponseEntity.ok(this.publicationService.updatePublication(publicationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable("id") Long publicationId) throws PublicationNotFoundException {
        this.publicationService.deletePublication(publicationId);
        return ResponseEntity.ok().build();
    }
}
