package org.mulu.pcms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectRequestDTO {
    private String title;
    private String description;
    private String imageUrl;
    private String githubLink;
    private String demoLink;
    private String categoryName;
    
}
