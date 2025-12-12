package org.mulu.pcms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponseDTO {
    private Long id;
    private String author;
    private String content;
    private String imageUrl;
    private String title;
}
