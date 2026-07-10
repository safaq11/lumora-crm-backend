package com.customercrm.service;

import java.util.List;

import com.customercrm.dto.CustomerLeadDTO;

import com.customercrm.enums.LeadStatus;
import com.customercrm.enums.Priority;

public interface CustomerLeadService {

    CustomerLeadDTO createCustomerLead(CustomerLeadDTO dto);

    List<CustomerLeadDTO> getAllCustomerLeads();

    CustomerLeadDTO getCustomerLeadById(Long id);

    CustomerLeadDTO updateCustomerLead(Long id, CustomerLeadDTO dto);

    void deleteCustomerLead(Long id);
    
    List<CustomerLeadDTO> searchByCustomerName(String customerName);

    List<CustomerLeadDTO> searchByMobile(String mobile);

    List<CustomerLeadDTO> searchByCity(String city);
    
    List<CustomerLeadDTO> filterLeads( String city, LeadStatus status, Priority priority, Long leadTypeId);

}