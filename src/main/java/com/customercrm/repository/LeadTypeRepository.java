package com.customercrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customercrm.entity.LeadType;

@Repository
public interface LeadTypeRepository extends JpaRepository<LeadType, Long> {

}