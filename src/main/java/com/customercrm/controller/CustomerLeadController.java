package com.customercrm.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.customercrm.dto.CustomerLeadDTO;
import com.customercrm.service.CustomerLeadService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestParam;
import com.customercrm.enums.LeadStatus;
import com.customercrm.enums.Priority;

@RestController
@RequestMapping("/api/customer-leads")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerLeadController {

    private final CustomerLeadService customerLeadService;

    public CustomerLeadController(CustomerLeadService customerLeadService) {
        this.customerLeadService = customerLeadService;
    }

    @PostMapping
    public ResponseEntity<CustomerLeadDTO> createCustomerLead(@Valid @RequestBody CustomerLeadDTO dto) {
        return new ResponseEntity<>(
                customerLeadService.createCustomerLead(dto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerLeadDTO>> getAllCustomerLeads() {
        return ResponseEntity.ok(customerLeadService.getAllCustomerLeads());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerLeadDTO> getCustomerLeadById(@PathVariable Long id) {
        return ResponseEntity.ok(customerLeadService.getCustomerLeadById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerLeadDTO> updateCustomerLead(
            @PathVariable Long id,
            @Valid @RequestBody CustomerLeadDTO dto) {

        return ResponseEntity.ok(customerLeadService.updateCustomerLead(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerLead(@PathVariable Long id) {

        customerLeadService.deleteCustomerLead(id);

        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search/name")
    public ResponseEntity<List<CustomerLeadDTO>> searchByCustomerName(
            @RequestParam String customerName) {

        return ResponseEntity.ok(
                customerLeadService.searchByCustomerName(customerName));
    }

    @GetMapping("/search/mobile")
    public ResponseEntity<List<CustomerLeadDTO>> searchByMobile(
            @RequestParam String mobile) {

        return ResponseEntity.ok(
                customerLeadService.searchByMobile(mobile));
    }

    @GetMapping("/search/city")
    public ResponseEntity<List<CustomerLeadDTO>> searchByCity(
            @RequestParam String city) {

        return ResponseEntity.ok(
                customerLeadService.searchByCity(city));
    }
    @GetMapping("/filter")
    public ResponseEntity<List<CustomerLeadDTO>> filterLeads(

            @RequestParam(required = false) String city,

            @RequestParam(required = false) LeadStatus status,

            @RequestParam(required = false) Priority priority,

            @RequestParam(required = false) Long leadTypeId) {

        return ResponseEntity.ok(customerLeadService.filterLeads(city, status,priority,leadTypeId));
    }
}