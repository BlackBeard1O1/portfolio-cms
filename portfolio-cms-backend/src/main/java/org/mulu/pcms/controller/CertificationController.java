package org.mulu.pcms.controller;

import java.util.List;

import org.mulu.pcms.dto.request.CertificationRequestDTO;
import org.mulu.pcms.dto.response.CertificationResponseDTO;
import org.mulu.pcms.service.CertificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/certifications")
public class CertificationController {
    
    private final CertificationService certificationService;

    @PostMapping("/create")
    public ResponseEntity<CertificationResponseDTO> createCertification(@RequestBody CertificationRequestDTO certification) {
        return ResponseEntity.ok(certificationService.createCertification(certification));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CertificationResponseDTO>> getAllCertifications() {
        return ResponseEntity.ok(certificationService.getAllCertifications());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CertificationResponseDTO> getCertificationById(@PathVariable Long id) {
        return ResponseEntity.ok(certificationService.getCertificationById(id));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<CertificationResponseDTO> updateCertification(@PathVariable Long id, @RequestBody CertificationRequestDTO certification) {
        return ResponseEntity.ok(certificationService.updateCertification(id, certification));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
        return ResponseEntity.ok().build();
    }

}
