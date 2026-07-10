package com.customercrm.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.customercrm.enums.LeadStatus;
import com.customercrm.enums.Priority;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class CustomerLeadDTO {

    private Long id;

    @NotBlank(message = "Customer Name is required")
    private String customerName;

    @NotBlank(message = "Mobile Number is required")
    @Pattern(
        regexp = "^[6-9]\\d{9}$",
        message = "Enter valid 10 digit mobile number"
    )
    private String mobile;

    private String alternateNumber;

    @Email(message = "Enter a valid email")
    private String email;

    private Long leadTypeId;

    private String leadTypeName;

    @NotBlank(message = "City is required")
    private String city;

    private String address;

    @NotBlank(message = "Requirement is required")
    private String requirement;

    private String leadSource;

    private String assignedExecutive;

    private String discussionDetails;

    private LocalDate visitDate;

    private LocalDate nextFollowUpDate;

    private LeadStatus status;

    private Priority priority;

    private LocalDateTime createdDate;

    public CustomerLeadDTO() {
    }

    public CustomerLeadDTO(Long id, String customerName, String mobile,
            String alternateNumber, String email,
            Long leadTypeId, String leadTypeName,
            String city, String address,
            String requirement, String leadSource,
            String assignedExecutive,
            String discussionDetails,
            LocalDate visitDate,
            LocalDate nextFollowUpDate,
            LeadStatus status,
            Priority priority,
            LocalDateTime createdDate) {

        this.id = id;
        this.customerName = customerName;
        this.mobile = mobile;
        this.alternateNumber = alternateNumber;
        this.email = email;
        this.leadTypeId = leadTypeId;
        this.leadTypeName = leadTypeName;
        this.city = city;
        this.address = address;
        this.requirement = requirement;
        this.leadSource = leadSource;
        this.assignedExecutive = assignedExecutive;
        this.discussionDetails = discussionDetails;
        this.visitDate = visitDate;
        this.nextFollowUpDate = nextFollowUpDate;
        this.status = status;
        this.priority = priority;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(String alternateNumber) {
        this.alternateNumber = alternateNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getLeadTypeId() {
        return leadTypeId;
    }

    public void setLeadTypeId(Long leadTypeId) {
        this.leadTypeId = leadTypeId;
    }

    public String getLeadTypeName() {
        return leadTypeName;
    }

    public void setLeadTypeName(String leadTypeName) {
        this.leadTypeName = leadTypeName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getLeadSource() {
        return leadSource;
    }

    public void setLeadSource(String leadSource) {
        this.leadSource = leadSource;
    }

    public String getAssignedExecutive() {
        return assignedExecutive;
    }

    public void setAssignedExecutive(String assignedExecutive) {
        this.assignedExecutive = assignedExecutive;
    }

    public String getDiscussionDetails() {
        return discussionDetails;
    }

    public void setDiscussionDetails(String discussionDetails) {
        this.discussionDetails = discussionDetails;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public LocalDate getNextFollowUpDate() {
        return nextFollowUpDate;
    }

    public void setNextFollowUpDate(LocalDate nextFollowUpDate) {
        this.nextFollowUpDate = nextFollowUpDate;
    }

    public LeadStatus getStatus() {
        return status;
    }

    public void setStatus(LeadStatus status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}