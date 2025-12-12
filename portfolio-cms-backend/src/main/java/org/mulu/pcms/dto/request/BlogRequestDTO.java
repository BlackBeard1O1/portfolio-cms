package org.mulu.pcms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogRequestDTO {
    private String content;
    private String imageUrl;
    private String title;

}
