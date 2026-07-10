package com.customercrm.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customercrm.dto.FollowUpDTO;
import com.customercrm.service.ReminderService;

@RestController
@RequestMapping("/api/reminders")
@CrossOrigin(origins = "http://localhost:4200")
public class ReminderController {

    private final ReminderService reminderService;

    public ReminderController(ReminderService reminderService) {
        this.reminderService = reminderService;
    }

    @GetMapping("/today")
    public ResponseEntity<List<FollowUpDTO>> todayReminders() {

        return ResponseEntity.ok(
                reminderService.getTodayReminders());

    }

    @GetMapping("/overdue")
    public ResponseEntity<List<FollowUpDTO>> overdueReminders() {

        return ResponseEntity.ok(
                reminderService.getOverdueReminders());

    }
    @GetMapping("/upcoming")
    public ResponseEntity<List<FollowUpDTO>> upcomingReminders() {

        return ResponseEntity.ok(
                reminderService.getUpcomingReminders());

    }

}