package com.customercrm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.customercrm.dto.CustomerLeadDTO;
import com.customercrm.entity.CustomerLead;
import com.customercrm.entity.LeadType;
import com.customercrm.repository.CustomerLeadRepository;
import com.customercrm.repository.LeadTypeRepository;
import com.customercrm.service.CustomerLeadService;
import com.customercrm.exception.ResourceNotFoundException;
import com.customercrm.specification.CustomerLeadSpecification;
import com.customercrm.enums.LeadStatus;
import com.customercrm.enums.Priority;

@Service
public class CustomerLeadServiceImpl implements CustomerLeadService {

    private final CustomerLeadRepository customerLeadRepository;
    private final LeadTypeRepository leadTypeRepository;

    public CustomerLeadServiceImpl(CustomerLeadRepository customerLeadRepository,
            LeadTypeRepository leadTypeRepository) {

        this.customerLeadRepository = customerLeadRepository;
        this.leadTypeRepository = leadTypeRepository;
    }

    @Override
    public CustomerLeadDTO createCustomerLead(CustomerLeadDTO dto) {

        LeadType leadType = leadTypeRepository.findById(dto.getLeadTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("Lead Type Not Found"));

        CustomerLead customerLead = new CustomerLead();

        customerLead.setCustomerName(dto.getCustomerName());
        customerLead.setMobile(dto.getMobile());
        customerLead.setAlternateNumber(dto.getAlternateNumber());
        customerLead.setEmail(dto.getEmail());
        customerLead.setLeadType(leadType);
        customerLead.setCity(dto.getCity());
        customerLead.setAddress(dto.getAddress());
        customerLead.setRequirement(dto.getRequirement());
        customerLead.setLeadSource(dto.getLeadSource());
        customerLead.setAssignedExecutive(dto.getAssignedExecutive());
        customerLead.setDiscussionDetails(dto.getDiscussionDetails());
        customerLead.setVisitDate(dto.getVisitDate());
        customerLead.setNextFollowUpDate(dto.getNextFollowUpDate());
        customerLead.setStatus(dto.getStatus());
        customerLead.setPriority(dto.getPriority());

        CustomerLead savedLead = customerLeadRepository.save(customerLead);

        CustomerLeadDTO response = new CustomerLeadDTO();

        response.setId(savedLead.getId());
        response.setCustomerName(savedLead.getCustomerName());
        response.setMobile(savedLead.getMobile());
        response.setAlternateNumber(savedLead.getAlternateNumber());
        response.setEmail(savedLead.getEmail());
        response.setLeadTypeId(savedLead.getLeadType().getId());
        response.setLeadTypeName(savedLead.getLeadType().getName());
        response.setCity(savedLead.getCity());
        response.setAddress(savedLead.getAddress());
        response.setRequirement(savedLead.getRequirement());
        response.setLeadSource(savedLead.getLeadSource());
        response.setAssignedExecutive(savedLead.getAssignedExecutive());
        response.setDiscussionDetails(savedLead.getDiscussionDetails());
        response.setVisitDate(savedLead.getVisitDate());
        response.setNextFollowUpDate(savedLead.getNextFollowUpDate());
        response.setStatus(savedLead.getStatus());
        response.setPriority(savedLead.getPriority());
        response.setCreatedDate(savedLead.getCreatedDate());

        return response;
    }

    @Override
    public List<CustomerLeadDTO> getAllCustomerLeads() {

        return customerLeadRepository.findAll().stream().map(customerLead -> {

            CustomerLeadDTO dto = new CustomerLeadDTO();

            dto.setId(customerLead.getId());
            dto.setCustomerName(customerLead.getCustomerName());
            dto.setMobile(customerLead.getMobile());
            dto.setAlternateNumber(customerLead.getAlternateNumber());
            dto.setEmail(customerLead.getEmail());
            dto.setLeadTypeId(customerLead.getLeadType().getId());
            dto.setLeadTypeName(customerLead.getLeadType().getName());
            dto.setCity(customerLead.getCity());
            dto.setAddress(customerLead.getAddress());
            dto.setRequirement(customerLead.getRequirement());
            dto.setLeadSource(customerLead.getLeadSource());
            dto.setAssignedExecutive(customerLead.getAssignedExecutive());
            dto.setDiscussionDetails(customerLead.getDiscussionDetails());
            dto.setVisitDate(customerLead.getVisitDate());
            dto.setNextFollowUpDate(customerLead.getNextFollowUpDate());
            dto.setStatus(customerLead.getStatus());
            dto.setPriority(customerLead.getPriority());
            dto.setCreatedDate(customerLead.getCreatedDate());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public CustomerLeadDTO getCustomerLeadById(Long id) {

        CustomerLead customerLead = customerLeadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        CustomerLeadDTO dto = new CustomerLeadDTO();

        dto.setId(customerLead.getId());
        dto.setCustomerName(customerLead.getCustomerName());
        dto.setMobile(customerLead.getMobile());
        dto.setAlternateNumber(customerLead.getAlternateNumber());
        dto.setEmail(customerLead.getEmail());
        dto.setLeadTypeId(customerLead.getLeadType().getId());
        dto.setLeadTypeName(customerLead.getLeadType().getName());
        dto.setCity(customerLead.getCity());
        dto.setAddress(customerLead.getAddress());
        dto.setRequirement(customerLead.getRequirement());
        dto.setLeadSource(customerLead.getLeadSource());
        dto.setAssignedExecutive(customerLead.getAssignedExecutive());
        dto.setDiscussionDetails(customerLead.getDiscussionDetails());
        dto.setVisitDate(customerLead.getVisitDate());
        dto.setNextFollowUpDate(customerLead.getNextFollowUpDate());
        dto.setStatus(customerLead.getStatus());
        dto.setPriority(customerLead.getPriority());
        dto.setCreatedDate(customerLead.getCreatedDate());

        return dto;
    }
    
    @Override
    public CustomerLeadDTO updateCustomerLead(Long id, CustomerLeadDTO dto) {

        CustomerLead customerLead = customerLeadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        LeadType leadType = leadTypeRepository.findById(dto.getLeadTypeId())
                .orElseThrow(() -> new  ResourceNotFoundException("Lead Type Not Found"));

        customerLead.setCustomerName(dto.getCustomerName());
        customerLead.setMobile(dto.getMobile());
        customerLead.setAlternateNumber(dto.getAlternateNumber());
        customerLead.setEmail(dto.getEmail());
        customerLead.setLeadType(leadType);
        customerLead.setCity(dto.getCity());
        customerLead.setAddress(dto.getAddress());
        customerLead.setRequirement(dto.getRequirement());
        customerLead.setLeadSource(dto.getLeadSource());
        customerLead.setAssignedExecutive(dto.getAssignedExecutive());
        customerLead.setDiscussionDetails(dto.getDiscussionDetails());
        customerLead.setVisitDate(dto.getVisitDate());
        customerLead.setNextFollowUpDate(dto.getNextFollowUpDate());
        customerLead.setStatus(dto.getStatus());
        customerLead.setPriority(dto.getPriority());

        CustomerLead updatedLead = customerLeadRepository.save(customerLead);

        return getCustomerLeadById(updatedLead.getId());
    }
  
    @Override
    public void deleteCustomerLead(Long id) {

        CustomerLead customerLead = customerLeadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        customerLeadRepository.delete(customerLead);
    }
    
    @Override
    public List<CustomerLeadDTO> searchByCustomerName(String customerName) {

        return customerLeadRepository
                .findByCustomerNameContainingIgnoreCase(customerName)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerLeadDTO> searchByMobile(String mobile) {

        return customerLeadRepository
                .findByMobileContaining(mobile)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerLeadDTO> searchByCity(String city) {

        return customerLeadRepository
                .findByCityContainingIgnoreCase(city)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<CustomerLeadDTO> filterLeads(
            String city,
            LeadStatus status,
            Priority priority,
            Long leadTypeId) {

        return customerLeadRepository.findAll(
                CustomerLeadSpecification.filterLeads(
                        city,
                        status,
                        priority,
                        leadTypeId))
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    private CustomerLeadDTO convertToDTO(CustomerLead customerLead) {

        CustomerLeadDTO dto = new CustomerLeadDTO();

        dto.setId(customerLead.getId());
        dto.setCustomerName(customerLead.getCustomerName());
        dto.setMobile(customerLead.getMobile());
        dto.setAlternateNumber(customerLead.getAlternateNumber());
        dto.setEmail(customerLead.getEmail());
        dto.setLeadTypeId(customerLead.getLeadType().getId());
        dto.setLeadTypeName(customerLead.getLeadType().getName());
        dto.setCity(customerLead.getCity());
        dto.setAddress(customerLead.getAddress());
        dto.setRequirement(customerLead.getRequirement());
        dto.setLeadSource(customerLead.getLeadSource());
        dto.setAssignedExecutive(customerLead.getAssignedExecutive());
        dto.setDiscussionDetails(customerLead.getDiscussionDetails());
        dto.setVisitDate(customerLead.getVisitDate());
        dto.setNextFollowUpDate(customerLead.getNextFollowUpDate());
        dto.setStatus(customerLead.getStatus());
        dto.setPriority(customerLead.getPriority());
        dto.setCreatedDate(customerLead.getCreatedDate());

        return dto;
    }


}