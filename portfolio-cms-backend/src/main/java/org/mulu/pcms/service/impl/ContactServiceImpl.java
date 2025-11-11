package org.mulu.pcms.service.impl;

import java.util.List;

import org.mulu.pcms.dto.request.ContactRequestDTO;
import org.mulu.pcms.dto.response.ContactResponseDTO;
import org.mulu.pcms.entity.Contact;
import org.mulu.pcms.mapper.ContactMapper;
import org.mulu.pcms.repository.ContactRepository;
import org.mulu.pcms.service.ContactService;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactMapper contactMapper;
    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactMapper contactMapper, ContactRepository contactRepository) {
        this.contactMapper = contactMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponseDTO createMessage(ContactRequestDTO contact) {

        Contact newContact =contactMapper.toEntity(contact);

        Contact savedContact = contactRepository.save(newContact);

        return contactMapper.toDto(savedContact);
        
    }

    @Override
    public List<ContactResponseDTO> getAllMessages() {
        List<Contact> contacts = contactRepository.findAll();
        return contacts.stream()
                .map(contactMapper::toDto)
                .toList();
    }

    @Override
    public ContactResponseDTO getMessageById(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));

        return contactMapper.toDto(contact);
    }

    @Override
    public void deleteMessage(Long id) {
        if(contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
        } else {
            throw new RuntimeException("Contact not found");
        }
    }

}
