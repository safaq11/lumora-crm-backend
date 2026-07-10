package com.customercrm.dto;

public class DashboardResponse {

    private long totalLeads;
    private long hotLeads;
    private long followUpsToday;
    private long closedWon;

    public DashboardResponse() {}

    public long getTotalLeads() {
        return totalLeads;
    }

    public void setTotalLeads(long totalLeads) {
        this.totalLeads = totalLeads;
    }

    public long getHotLeads() {
        return hotLeads;
    }

    public void setHotLeads(long hotLeads) {
        this.hotLeads = hotLeads;
    }

    public long getFollowUpsToday() {
        return followUpsToday;
    }

    public void setFollowUpsToday(long followUpsToday) {
        this.followUpsToday = followUpsToday;
    }

    public long getClosedWon() {
        return closedWon;
    }

    public void setClosedWon(long closedWon) {
        this.closedWon = closedWon;
    }
}