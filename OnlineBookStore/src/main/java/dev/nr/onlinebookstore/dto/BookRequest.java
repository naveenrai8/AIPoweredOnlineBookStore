package dev.nr.onlinebookstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class BookRequest {
    private String title;
    private String isbn;
    private Long authorId;
    private Long publicationId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedAt;
}
