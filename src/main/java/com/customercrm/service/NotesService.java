package com.customercrm.service;

import java.util.List;

import com.customercrm.dto.NotesDTO;

public interface NotesService {

    NotesDTO addNote(NotesDTO dto);

    List<NotesDTO> getAllNotes();

    List<NotesDTO> getNotesByLead(Long customerLeadId);

    NotesDTO updateNote(Long id, NotesDTO dto);

    void deleteNote(Long id);

}