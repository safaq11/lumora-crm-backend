package com.customercrm.dto;

import jakarta.validation.constraints.NotBlank;

public class LeadTypeDTO {

    private Long id;

    @NotBlank(message = "Lead Type Name is required")
    private String name;

    @NotBlank(message = "Description is required")
    private String description;

    private Boolean active;

    public LeadTypeDTO() {
    }

    public LeadTypeDTO(Long id, String name, String description, Boolean active) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

}