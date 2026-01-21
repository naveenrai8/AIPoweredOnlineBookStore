package dev.nr.onlinebookstore.bookservice.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookResponse {
    Long id;
    String name;
    String isbn;
    Long authorId;
    Long publicationId;
    Date publishedAt;
}
