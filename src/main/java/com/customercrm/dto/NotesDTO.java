package com.customercrm.dto;

import java.time.LocalDateTime;

public class NotesDTO {

    private Long id;

    private String note;

    private LocalDateTime createdDate;

    private Long customerLeadId;

    public NotesDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Long getCustomerLeadId() {
        return customerLeadId;
    }

    public void setCustomerLeadId(Long customerLeadId) {
        this.customerLeadId = customerLeadId;
    }

}