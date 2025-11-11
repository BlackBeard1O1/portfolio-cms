package org.mulu.pcms.service;

import java.util.List;

import org.mulu.pcms.dto.request.CertificationRequestDTO;
import org.mulu.pcms.dto.response.CertificationResponseDTO;

public interface CertificationService {

    CertificationResponseDTO createCertification(CertificationRequestDTO certification);

    List<CertificationResponseDTO> getAllCertifications();

    CertificationResponseDTO getCertificationById(Long id);

    CertificationResponseDTO updateCertification(Long id, CertificationRequestDTO certification);

    void deleteCertification(Long id);
}
