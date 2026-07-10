package com.customercrm.specification;

import org.springframework.data.jpa.domain.Specification;

import com.customercrm.entity.CustomerLead;
import com.customercrm.enums.LeadStatus;
import com.customercrm.enums.Priority;

public class CustomerLeadSpecification {

    public static Specification<CustomerLead> filterLeads(
            String city,
            LeadStatus status,
            Priority priority,
            Long leadTypeId) {

        return (root, query, cb) -> {

            var predicate = cb.conjunction();

            if (city != null && !city.isEmpty()) {
                predicate.getExpressions().add(
                        cb.like(
                                cb.lower(root.get("city")),
                                "%" + city.toLowerCase() + "%"));
            }

            if (status != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("status"), status));
            }

            if (priority != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("priority"), priority));
            }

            if (leadTypeId != null) {
                predicate.getExpressions().add(
                        cb.equal(root.get("leadType").get("id"), leadTypeId));
            }

            return predicate;
        };
    }

}