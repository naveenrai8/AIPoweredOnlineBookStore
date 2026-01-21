package dev.nr.onlinebookstore.bookservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class BookRequest {
    private String name;
    private String isbn;
    private Long authorId;
    private Long publicationId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishedAt;
}
