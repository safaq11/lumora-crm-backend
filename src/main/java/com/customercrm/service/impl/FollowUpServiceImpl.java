package com.customercrm.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.customercrm.dto.FollowUpDTO;
import com.customercrm.entity.CustomerLead;
import com.customercrm.entity.FollowUp;
import com.customercrm.exception.ResourceNotFoundException;
import com.customercrm.repository.CustomerLeadRepository;
import com.customercrm.repository.FollowUpRepository;
import com.customercrm.service.FollowUpService;

@Service
public class FollowUpServiceImpl implements FollowUpService {

    private final FollowUpRepository followUpRepository;
    private final CustomerLeadRepository customerLeadRepository;

    public FollowUpServiceImpl(FollowUpRepository followUpRepository,
                               CustomerLeadRepository customerLeadRepository) {
        this.followUpRepository = followUpRepository;
        this.customerLeadRepository = customerLeadRepository;
    }

    @Override
    public FollowUpDTO createFollowUp(FollowUpDTO dto) {

        CustomerLead customerLead = customerLeadRepository.findById(dto.getCustomerLeadId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        FollowUp followUp = new FollowUp();

        followUp.setCustomerLead(customerLead);
        followUp.setDiscussion(dto.getDiscussion());
        followUp.setNextFollowUpDate(dto.getNextFollowUpDate());
        followUp.setRemarks(dto.getRemarks());

        FollowUp saved = followUpRepository.save(followUp);

        return convertToDTO(saved);
    }

    @Override
    public List<FollowUpDTO> getAllFollowUps() {

        return followUpRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FollowUpDTO getFollowUpById(Long id) {

        FollowUp followUp = followUpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Follow Up Not Found"));

        return convertToDTO(followUp);
    }

    @Override
    public FollowUpDTO updateFollowUp(Long id, FollowUpDTO dto) {

        FollowUp followUp = followUpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Follow Up Not Found"));

        CustomerLead customerLead = customerLeadRepository.findById(dto.getCustomerLeadId())
                .orElseThrow(() -> new ResourceNotFoundException("Customer Lead Not Found"));

        followUp.setCustomerLead(customerLead);
        followUp.setDiscussion(dto.getDiscussion());
        followUp.setNextFollowUpDate(dto.getNextFollowUpDate());
        followUp.setRemarks(dto.getRemarks());

        FollowUp updated = followUpRepository.save(followUp);

        return convertToDTO(updated);
    }

    @Override
    public void deleteFollowUp(Long id) {

        FollowUp followUp = followUpRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Follow Up Not Found"));

        followUpRepository.delete(followUp);
    }

    @Override
    public List<FollowUpDTO> getTodayFollowUps(LocalDate date) {

        return followUpRepository.findByNextFollowUpDate(date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FollowUpDTO> getOverdueFollowUps(LocalDate date) {

        return followUpRepository.findByNextFollowUpDateLessThan(date)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public List<FollowUpDTO> getUpcomingFollowUps() {

        return followUpRepository
                .findByNextFollowUpDateBetween(
                        LocalDate.now().plusDays(1),
                        LocalDate.now().plusDays(7))
                .stream()
                .map(this::convertToDTO)
                .toList();

    }

    private FollowUpDTO convertToDTO(FollowUp followUp) {

        FollowUpDTO dto = new FollowUpDTO();

        dto.setId(followUp.getId());
        dto.setCustomerLeadId(followUp.getCustomerLead().getId());
        dto.setCustomerName(followUp.getCustomerLead().getCustomerName());
        dto.setDiscussion(followUp.getDiscussion());
        dto.setNextFollowUpDate(followUp.getNextFollowUpDate());
        dto.setRemarks(followUp.getRemarks());
        dto.setCreatedDate(followUp.getCreatedDate());

        return dto;
    }
}