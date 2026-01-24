package dev.nr.onlinebookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookResponse {
    Long id;
    String title;
    String isbn;
    Long authorId;
    Long publicationId;
    LocalDate publishedAt;
}
