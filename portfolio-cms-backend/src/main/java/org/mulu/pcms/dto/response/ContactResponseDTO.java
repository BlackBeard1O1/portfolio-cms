package org.mulu.pcms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactResponseDTO {
    private Long id;
    private String message;
    private String email;
    private String name;
}
