package org.mulu.pcms.service;

import java.util.List;

import org.mulu.pcms.dto.request.ContactRequestDTO;
import org.mulu.pcms.dto.response.ContactResponseDTO;

public interface ContactService {

    ContactResponseDTO createMessage(ContactRequestDTO contact);

    List<ContactResponseDTO> getAllMessages();

    ContactResponseDTO getMessageById(Long id);

    void deleteMessage(Long id);
}
