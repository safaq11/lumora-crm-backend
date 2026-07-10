package com.customercrm.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "follow_up")
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_lead_id", nullable = false)
    private CustomerLead customerLead;

    @Column(length = 2000)
    private String discussion;

    private LocalDate nextFollowUpDate;

    private String remarks;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    public FollowUp() {
    }

    public FollowUp(Long id, CustomerLead customerLead, String discussion,
            LocalDate nextFollowUpDate, String remarks,
            LocalDateTime createdDate) {

        this.id = id;
        this.customerLead = customerLead;
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

    public CustomerLead getCustomerLead() {
        return customerLead;
    }

    public void setCustomerLead(CustomerLead customerLead) {
        this.customerLead = customerLead;
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