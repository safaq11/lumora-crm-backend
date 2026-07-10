package com.customercrm.service.impl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.customercrm.dto.DashboardDTO;
import com.customercrm.enums.LeadStatus;
import com.customercrm.enums.Priority;
import com.customercrm.repository.CustomerLeadRepository;
import com.customercrm.repository.FollowUpRepository;
import com.customercrm.service.DashboardService;
import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final CustomerLeadRepository customerLeadRepository;
    private final FollowUpRepository followUpRepository;

    public DashboardServiceImpl(CustomerLeadRepository customerLeadRepository,
                                FollowUpRepository followUpRepository) {

        this.customerLeadRepository = customerLeadRepository;
        this.followUpRepository = followUpRepository;
    }

    @Override
    public DashboardDTO getDashboardData() {

        DashboardDTO dashboard = new DashboardDTO();

        dashboard.setTotalLeads(customerLeadRepository.count());

        dashboard.setTodayFollowUps(
                followUpRepository.findByNextFollowUpDate(LocalDate.now()).size());

        dashboard.setPendingFollowUps(
                followUpRepository.findByNextFollowUpDateLessThan(LocalDate.now()).size());

        dashboard.setHotCustomers(
                customerLeadRepository.countByPriority(Priority.HOT));

        dashboard.setClosedDeals(
                customerLeadRepository.countByStatus(LeadStatus.CLOSED_WON));
        
     // ===============================
     // Status Counts
     // ===============================

     Map<String, Long> statusCounts = new HashMap<>();

     customerLeadRepository.countByStatusGroup()

     .forEach(obj ->

     statusCounts.put(

     obj[0].toString(),

     (Long) obj[1]

     )

     );

     dashboard.setStatusCounts(statusCounts);


     // ===============================
     // Priority Counts
     // ===============================

     Map<String, Long> priorityCounts = new HashMap<>();

     customerLeadRepository.countByPriorityGroup()

     .forEach(obj ->

     priorityCounts.put(

     obj[0].toString(),

     (Long) obj[1]

     )

     );

     dashboard.setPriorityCounts(priorityCounts);

        return dashboard;
    }
}