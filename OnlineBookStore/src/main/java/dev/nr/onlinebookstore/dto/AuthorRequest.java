package dev.nr.onlinebookstore.dto;

import dev.nr.onlinebookstore.markers.OnCreate;
import dev.nr.onlinebookstore.markers.OnUpdate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    @Null(groups = OnCreate.class, message = "Id must be null while adding Author")
    @NotNull(groups = OnUpdate.class, message = "Id mustn't be null while updating Author")
    private Long id;

    private String name;

    private String email;
}
