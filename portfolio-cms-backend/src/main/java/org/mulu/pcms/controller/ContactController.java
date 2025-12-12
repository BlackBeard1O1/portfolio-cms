package org.mulu.pcms.controller;

import java.util.List;

import org.mulu.pcms.dto.request.ContactRequestDTO;
import org.mulu.pcms.dto.response.ContactResponseDTO;
import org.mulu.pcms.service.ContactService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactController {
    
    private final ContactService contactService;

    @PostMapping("/create")
    public ResponseEntity<ContactResponseDTO> createMessage(@RequestBody ContactRequestDTO contact) {
        return ResponseEntity.ok(contactService.createMessage(contact));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ContactResponseDTO>> getAllMessages() {
        return ResponseEntity.ok(contactService.getAllMessages());
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ContactResponseDTO> getMessageById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.getMessageById(id));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        contactService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }

}
