package com.customercrm.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customercrm.entity.FollowUp;

public interface FollowUpRepository extends JpaRepository<FollowUp, Long> {

    List<FollowUp> findByNextFollowUpDate(LocalDate date);

    List<FollowUp> findByNextFollowUpDateLessThan(LocalDate date);
    
    List<FollowUp> findByNextFollowUpDateBetween(
            LocalDate startDate,
            LocalDate endDate);
    

}