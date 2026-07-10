package com.customercrm.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.customercrm.dto.LeadTypeDTO;
import com.customercrm.entity.LeadType;
import com.customercrm.repository.LeadTypeRepository;
import com.customercrm.service.LeadTypeService;
import com.customercrm.exception.ResourceNotFoundException;

@Service
public class LeadTypeServiceImpl implements LeadTypeService {

    private final LeadTypeRepository repository;

    public LeadTypeServiceImpl(LeadTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public LeadTypeDTO createLeadType(LeadTypeDTO dto) {

        LeadType leadType = new LeadType();

        leadType.setName(dto.getName());
        leadType.setDescription(dto.getDescription());
        leadType.setActive(dto.getActive());

        LeadType savedLeadType = repository.save(leadType);

        LeadTypeDTO response = new LeadTypeDTO();

        response.setId(savedLeadType.getId());
        response.setName(savedLeadType.getName());
        response.setDescription(savedLeadType.getDescription());
        response.setActive(savedLeadType.getActive());

        return response;
    }

    @Override
    public List<LeadTypeDTO> getAllLeadTypes() {

        return repository.findAll()
                .stream()
                .map(leadType -> {
                    LeadTypeDTO dto = new LeadTypeDTO();

                    dto.setId(leadType.getId());
                    dto.setName(leadType.getName());
                    dto.setDescription(leadType.getDescription());
                    dto.setActive(leadType.getActive());

                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public LeadTypeDTO getLeadTypeById(Long id) {

        LeadType leadType = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead Type not found"));

        LeadTypeDTO dto = new LeadTypeDTO();

        dto.setId(leadType.getId());
        dto.setName(leadType.getName());
        dto.setDescription(leadType.getDescription());
        dto.setActive(leadType.getActive());

        return dto;
    }

    @Override
    public LeadTypeDTO updateLeadType(Long id, LeadTypeDTO dto) {

        LeadType leadType = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        leadType.setName(dto.getName());
        leadType.setDescription(dto.getDescription());
        leadType.setActive(dto.getActive());

        LeadType updatedLeadType = repository.save(leadType);

        LeadTypeDTO response = new LeadTypeDTO();

        response.setId(updatedLeadType.getId());
        response.setName(updatedLeadType.getName());
        response.setDescription(updatedLeadType.getDescription());
        response.setActive(updatedLeadType.getActive());

        return response;
    }

    @Override
    public void deleteLeadType(Long id) {

        LeadType leadType = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        repository.delete(leadType);
    }
}