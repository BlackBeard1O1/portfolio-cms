package org.mulu.pcms.mapper;

import org.mulu.pcms.dto.request.CertificationRequestDTO;
import org.mulu.pcms.dto.response.CertificationResponseDTO;
import org.mulu.pcms.entity.Certification;
import org.springframework.stereotype.Component;

@Component
public class CertificationMapper {

    public static Certification toEntity(CertificationRequestDTO certification) {
        if (certification == null)
            return null;

        Certification certificationEntity = new Certification();
        certificationEntity.setName(certification.getName());
        certificationEntity.setImageUrl(certification.getImageUrl());
        certificationEntity.setDateObtained(certification.getDateObtained());

        return certificationEntity;
    }

    public CertificationResponseDTO toDTO(Certification savedCertification) {
        if (savedCertification == null)
            return null;

        CertificationResponseDTO certificationDTO = new CertificationResponseDTO();
        certificationDTO.setId(savedCertification.getId());
        certificationDTO.setName(savedCertification.getName());
        certificationDTO.setInstitution(savedCertification.getInstitution());
        certificationDTO.setCertificateUrl(savedCertification.getCertificateUrl());
        certificationDTO.setImageUrl(savedCertification.getImageUrl());
        certificationDTO.setDateObtained(savedCertification.getDateObtained());

        return certificationDTO;
    }

    public static Certification updateCertification(Certification existingCertification,
            CertificationRequestDTO certification) {
        if (certification == null || existingCertification == null) {
            throw new IllegalArgumentException("Certification and existingCertification must not be null");
        }

        if (existingCertification.getName() != null)
            existingCertification.setName(certification.getName());

        if (existingCertification.getInstitution() != null)
            existingCertification.setInstitution(certification.getInstitution());

        if (existingCertification.getImageUrl() != null)
            existingCertification.setImageUrl(certification.getImageUrl());

        if (existingCertification.getDateObtained() != null)
            existingCertification.setDateObtained(certification.getDateObtained());

        if (existingCertification.getCertificateUrl() != null)
            existingCertification.setCertificateUrl(certification.getCertificateUrl());

        return existingCertification;

    }
}
