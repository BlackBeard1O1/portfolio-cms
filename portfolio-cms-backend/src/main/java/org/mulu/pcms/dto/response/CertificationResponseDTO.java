package org.mulu.pcms.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationResponseDTO {
    private Long id;
    private String name;
    private String imageUrl;
    private String certificateUrl;
    private String institution;
    private String dateObtained;

}
