package com.istad.miniprojectspring.model.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtitleRequest {

    @NotEmpty(message = "Title cannot be empty !")
    private String title;
    @NotEmpty(message = "Description cannot be empty!")
    private String description;
    private MultipartFile file;
    private int authorID;
}
