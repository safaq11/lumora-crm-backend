package com.customercrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customercrm.entity.CustomerLead;

import com.customercrm.enums.LeadStatus;
import com.customercrm.enums.Priority;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CustomerLeadRepository extends JpaRepository<CustomerLead, Long>,  JpaSpecificationExecutor<CustomerLead> {
	long countByPriority(Priority priority);

	long countByStatus(LeadStatus status);
	
	List<CustomerLead> findByCustomerNameContainingIgnoreCase(String customerName);

	List<CustomerLead> findByMobileContaining(String mobile);

	List<CustomerLead> findByCityContainingIgnoreCase(String city);
	
	long count();

	long countByPriority(String priority);

	long countByStatus(String status);
	@Query("""
			SELECT c.status, COUNT(c)
			FROM CustomerLead c
			GROUP BY c.status
			""")
			List<Object[]> countByStatusGroup();
	@Query("""
					SELECT c.priority, COUNT(c)
					FROM CustomerLead c
					GROUP BY c.priority
					""")
					List<Object[]> countByPriorityGroup();

}