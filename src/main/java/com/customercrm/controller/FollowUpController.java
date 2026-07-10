package com.customercrm.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customercrm.dto.FollowUpDTO;
import com.customercrm.service.FollowUpService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/follow-ups")
@CrossOrigin(origins = "http://localhost:4200")
public class FollowUpController {

    private final FollowUpService followUpService;

    public FollowUpController(FollowUpService followUpService) {
        this.followUpService = followUpService;
    }

    @PostMapping
    public ResponseEntity<FollowUpDTO> createFollowUp(@Valid @RequestBody FollowUpDTO dto) {

        return new ResponseEntity<>(
                followUpService.createFollowUp(dto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FollowUpDTO>> getAllFollowUps() {

        return ResponseEntity.ok(followUpService.getAllFollowUps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FollowUpDTO> getFollowUpById(@PathVariable Long id) {

        return ResponseEntity.ok(followUpService.getFollowUpById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FollowUpDTO> updateFollowUp(
            @PathVariable Long id,
            @Valid @RequestBody FollowUpDTO dto) {

        return ResponseEntity.ok(followUpService.updateFollowUp(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFollowUp(@PathVariable Long id) {

        followUpService.deleteFollowUp(id);

        return ResponseEntity.ok("Follow Up Deleted Successfully");
    }

    @GetMapping("/today")
    public ResponseEntity<List<FollowUpDTO>> todayFollowUps() {

        return ResponseEntity.ok(
                followUpService.getTodayFollowUps(LocalDate.now()));
    }

    @GetMapping("/overdue")
    public ResponseEntity<List<FollowUpDTO>> overdueFollowUps() {

        return ResponseEntity.ok(
                followUpService.getOverdueFollowUps(LocalDate.now()));
    }

}