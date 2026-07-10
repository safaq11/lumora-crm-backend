package com.customercrm.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.customercrm.dto.FollowUpDTO;
import com.customercrm.service.FollowUpService;
import com.customercrm.service.ReminderService;

@Service
public class ReminderServiceImpl implements ReminderService {

    private final FollowUpService followUpService;

    public ReminderServiceImpl(FollowUpService followUpService) {
        this.followUpService = followUpService;
    }

    @Override
    public List<FollowUpDTO> getTodayReminders() {

        return followUpService.getTodayFollowUps(LocalDate.now());

    }

    @Override
    public List<FollowUpDTO> getOverdueReminders() {

        return followUpService.getOverdueFollowUps(LocalDate.now());

    }
    
    @Override
    public List<FollowUpDTO> getUpcomingReminders() {

        return followUpService.getUpcomingFollowUps();

    }

}