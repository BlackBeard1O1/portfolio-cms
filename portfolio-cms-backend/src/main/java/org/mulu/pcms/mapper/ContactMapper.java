package org.mulu.pcms.mapper;

import org.mulu.pcms.dto.request.ContactRequestDTO;
import org.mulu.pcms.dto.response.ContactResponseDTO;
import org.mulu.pcms.entity.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

    public Contact toEntity(ContactRequestDTO contact) {
        if(contact == null)
            return null;

        Contact newContact = new Contact();

        newContact.setName(contact.getName());
        newContact.setEmail(contact.getEmail());
        newContact.setMessage(contact.getMessage());

        return newContact;
    }

    public ContactResponseDTO toDto(Contact savedContact) {
        if(savedContact == null)
            return null;

        ContactResponseDTO newContact = new ContactResponseDTO();

        newContact.setId(savedContact.getId());
        newContact.setName(savedContact.getName());
        newContact.setEmail(savedContact.getEmail());
        newContact.setMessage(savedContact.getMessage());

        return newContact;
    }
    
}
