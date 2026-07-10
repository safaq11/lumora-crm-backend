package com.customercrm.service;

import java.util.List;

import com.customercrm.dto.LeadTypeDTO;

public interface LeadTypeService {

    LeadTypeDTO createLeadType(LeadTypeDTO leadTypeDTO);

    List<LeadTypeDTO> getAllLeadTypes();

    LeadTypeDTO getLeadTypeById(Long id);

    LeadTypeDTO updateLeadType(Long id, LeadTypeDTO leadTypeDTO);

    void deleteLeadType(Long id);

}