package org.mulu.pcms.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificationRequestDTO {
    private String name;
    private String imageUrl;
    private String certificateUrl;
    private String institution;
    private String dateObtained;

}
