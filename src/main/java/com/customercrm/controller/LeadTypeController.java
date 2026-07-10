package com.customercrm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customercrm.dto.LeadTypeDTO;
import com.customercrm.service.LeadTypeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/lead-types")
@CrossOrigin(origins = "http://localhost:4200")
public class LeadTypeController {

    private final LeadTypeService leadTypeService;

    public LeadTypeController(LeadTypeService leadTypeService) {
        this.leadTypeService = leadTypeService;
    }

    @PostMapping
    public ResponseEntity<LeadTypeDTO> createLeadType(@Valid @RequestBody LeadTypeDTO dto) {

        LeadTypeDTO savedLeadType = leadTypeService.createLeadType(dto);

        return new ResponseEntity<>(savedLeadType, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LeadTypeDTO>> getAllLeadTypes() {

        return ResponseEntity.ok(leadTypeService.getAllLeadTypes());
    }
    @GetMapping("/{id}")
    public ResponseEntity<LeadTypeDTO> getLeadTypeById(@PathVariable Long id) {

        return ResponseEntity.ok(leadTypeService.getLeadTypeById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<LeadTypeDTO> updateLeadType(@PathVariable Long id,@Valid @RequestBody LeadTypeDTO dto) {

        return ResponseEntity.ok(leadTypeService.updateLeadType(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeadType(@PathVariable Long id){

        leadTypeService.deleteLeadType(id);

        return ResponseEntity.ok().build();

    }
}