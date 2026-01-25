package dev.nr.onlinebookstore.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.nr.onlinebookstore.markers.OnCreate;
import dev.nr.onlinebookstore.markers.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
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
    @Null(groups = OnCreate.class, message = "Id must be null while adding new book")
    @NotNull(groups = OnUpdate.class, message = "Id mustn't be null while updating book")
    private Long id;
    private String title;
    private String isbn;
    private Long authorId;
    private Long publicationId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publishedAt;
}
