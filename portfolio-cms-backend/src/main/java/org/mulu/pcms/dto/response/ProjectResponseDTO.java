package org.mulu.pcms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private String githubLink;
    private String demoLink;
    private String user;
}