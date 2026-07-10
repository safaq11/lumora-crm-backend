package com.customercrm.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FollowUpDTO {

    private Long id;

    @NotNull(message = "Customer Lead Id is required")
    private Long customerLeadId;

    private String customerName;

    @NotBlank(message = "Discussion is required")
    private String discussion;

    @NotNull(message = "Next Follow-up Date is required")
    private LocalDate nextFollowUpDate;

    private String remarks;

    private LocalDateTime createdDate;

    public FollowUpDTO() {
    }

    public FollowUpDTO(Long id, Long customerLeadId, String customerName,
            String discussion, LocalDate nextFollowUpDate,
            String remarks, LocalDateTime createdDate) {

        this.id = id;
        this.customerLeadId = customerLeadId;
        this.customerName = customerName;
        this.discussion = discussion;
        this.nextFollowUpDate = nextFollowUpDate;
        this.remarks = remarks;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerLeadId() {
        return customerLeadId;
    }

    public void setCustomerLeadId(Long customerLeadId) {
        this.customerLeadId = customerLeadId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDiscussion() {
        return discussion;
    }

    public void setDiscussion(String discussion) {
        this.discussion = discussion;
    }

    public LocalDate getNextFollowUpDate() {
        return nextFollowUpDate;
    }

    public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
        this.nextFollowUpDate = nextFollowUpDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}