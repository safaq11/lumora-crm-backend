package com.customercrm.service;

import java.time.LocalDate;
import java.util.List;

import com.customercrm.dto.FollowUpDTO;

public interface FollowUpService {

    FollowUpDTO createFollowUp(FollowUpDTO dto);

    List<FollowUpDTO> getAllFollowUps();

    FollowUpDTO getFollowUpById(Long id);

    FollowUpDTO updateFollowUp(Long id, FollowUpDTO dto);

    void deleteFollowUp(Long id);

    List<FollowUpDTO> getTodayFollowUps(LocalDate date);

    List<FollowUpDTO> getOverdueFollowUps(LocalDate date);
    
    List<FollowUpDTO> getUpcomingFollowUps();

}