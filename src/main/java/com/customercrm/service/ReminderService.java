package com.customercrm.service;

import java.util.List;

import com.customercrm.dto.FollowUpDTO;

public interface ReminderService {

    List<FollowUpDTO> getTodayReminders();

    List<FollowUpDTO> getOverdueReminders();
    
    List<FollowUpDTO> getUpcomingReminders();

}