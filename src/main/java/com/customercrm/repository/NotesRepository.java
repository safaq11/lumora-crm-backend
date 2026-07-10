package com.customercrm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customercrm.entity.Notes;

public interface NotesRepository extends JpaRepository<Notes,Long>{

    List<Notes> findByCustomerLeadId(Long customerLeadId);

}