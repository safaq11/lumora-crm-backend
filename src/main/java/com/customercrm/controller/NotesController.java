package com.customercrm.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customercrm.dto.NotesDTO;
import com.customercrm.service.NotesService;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin(origins = "http://localhost:4200")
public class NotesController {

    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping
    public ResponseEntity<NotesDTO> addNote(@RequestBody NotesDTO dto) {

        return ResponseEntity.ok(notesService.addNote(dto));
    }
    @GetMapping
    public ResponseEntity<List<NotesDTO>> getAllNotes() {

        return ResponseEntity.ok(
                notesService.getAllNotes());

    }
    @PutMapping("/{id}")
    public ResponseEntity<NotesDTO> updateNote(
            @PathVariable Long id,
            @RequestBody NotesDTO dto) {

        return ResponseEntity.ok(
                notesService.updateNote(id, dto));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNote(
            @PathVariable Long id) {

        notesService.deleteNote(id);

        return ResponseEntity.ok("Note Deleted Successfully");

    }

    @GetMapping("/{customerLeadId}")
    public ResponseEntity<List<NotesDTO>> getNotesByLead(
            @PathVariable Long customerLeadId) {

        return ResponseEntity.ok(
                notesService.getNotesByLead(customerLeadId));
    }

}