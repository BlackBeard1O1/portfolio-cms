package org.mulu.pcms.service.impl;

import java.util.List;

import org.mulu.pcms.dto.request.CertificationRequestDTO;
import org.mulu.pcms.dto.response.CertificationResponseDTO;
import org.mulu.pcms.entity.Certification;
import org.mulu.pcms.mapper.CertificationMapper;
import org.mulu.pcms.repository.CertificationRepository;
import org.mulu.pcms.service.CertificationService;
import org.springframework.stereotype.Service;

@Service
public class CertificationServiceImpl implements CertificationService {

    private final CertificationRepository certificationRepository;
    private final CertificationMapper certificationMapper;

    public CertificationServiceImpl(CertificationRepository certificationRepository,
            CertificationMapper certificationMapper) {
        this.certificationRepository = certificationRepository;
        this.certificationMapper = certificationMapper;
    }

    @Override
    public CertificationResponseDTO createCertification(CertificationRequestDTO certification) {
        Certification newCertification = CertificationMapper.toEntity(certification);

        Certification savedCertification = certificationRepository.save(newCertification);

        return certificationMapper.toDTO(savedCertification);

    }

    @Override
    public List<CertificationResponseDTO> getAllCertifications() {
        List<Certification> certifications = certificationRepository.findAll();
        return certifications.stream()
                .map(certificationMapper::toDTO)
                .toList();
    }

    @Override
    public CertificationResponseDTO getCertificationById(Long id) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return certificationMapper.toDTO(certification);

    }

    @Override
    public CertificationResponseDTO updateCertification(Long id, CertificationRequestDTO certification) {
        Certification existingCertification = certificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Certification updatedCertification = CertificationMapper.updateCertification(existingCertification,
                certification);
        Certification savedCertification = certificationRepository.save(updatedCertification);
        return certificationMapper.toDTO(savedCertification);
    }

    @Override
    public void deleteCertification(Long id) {
        if(!certificationRepository.existsById(id)){
            throw new RuntimeException("Certification not found");
        }
        certificationRepository.deleteById(id);

    }

}
