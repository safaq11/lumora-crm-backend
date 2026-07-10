package com.customercrm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.customercrm.dto.NotesDTO;
import com.customercrm.entity.CustomerLead;
import com.customercrm.entity.Notes;
import com.customercrm.exception.ResourceNotFoundException;
import com.customercrm.repository.CustomerLeadRepository;
import com.customercrm.repository.NotesRepository;
import com.customercrm.service.NotesService;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;
    private final CustomerLeadRepository customerLeadRepository;

    public NotesServiceImpl(NotesRepository notesRepository,
                            CustomerLeadRepository customerLeadRepository) {

        this.notesRepository = notesRepository;
        this.customerLeadRepository = customerLeadRepository;
    }

    @Override
    public NotesDTO addNote(NotesDTO dto) {

        CustomerLead customerLead = customerLeadRepository
                .findById(dto.getCustomerLeadId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        Notes note = new Notes();

        note.setNote(dto.getNote());
        note.setCustomerLead(customerLead);

        Notes savedNote = notesRepository.save(note);

        return convertToDTO(savedNote);
    }

    @Override
    public List<NotesDTO> getNotesByLead(Long customerLeadId) {

        return notesRepository.findByCustomerLeadId(customerLeadId)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<NotesDTO> getAllNotes() {

        return notesRepository.findAll()

                .stream()

                .map(this::convertToDTO)

                .collect(Collectors.toList());

    }
    @Override
    public NotesDTO updateNote(Long id, NotesDTO dto) {

        Notes note = notesRepository.findById(id)

                .orElseThrow(() ->
                        new ResourceNotFoundException("Note Not Found"));

        CustomerLead customerLead = customerLeadRepository

                .findById(dto.getCustomerLeadId())

                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer Lead Not Found"));

        note.setNote(dto.getNote());

        note.setCustomerLead(customerLead);

        Notes updated = notesRepository.save(note);

        return convertToDTO(updated);

    }
    @Override
    public void deleteNote(Long id) {

        Notes note = notesRepository.findById(id)

                .orElseThrow(() ->
                        new ResourceNotFoundException("Note Not Found"));

        notesRepository.delete(note);

    }
    private NotesDTO convertToDTO(Notes notes) {

        NotesDTO dto = new NotesDTO();

        dto.setId(notes.getId());
        dto.setNote(notes.getNote());
        dto.setCreatedDate(notes.getCreatedDate());
        dto.setCustomerLeadId(notes.getCustomerLead().getId());

        return dto;
    }

}