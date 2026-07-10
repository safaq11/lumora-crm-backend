package com.customercrm.dto;
import java.util.Map;

public class DashboardDTO {

    private long totalLeads;

    private long todayFollowUps;

    private long pendingFollowUps;

    private long hotCustomers;

    private long closedDeals;
    
    private Map<String, Long> statusCounts;

    private Map<String, Long> priorityCounts;
    
    public DashboardDTO() {
    }

    public DashboardDTO(long totalLeads, long todayFollowUps,
            long pendingFollowUps, long hotCustomers,
            long closedDeals) {

        this.totalLeads = totalLeads;
        this.todayFollowUps = todayFollowUps;
        this.pendingFollowUps = pendingFollowUps;
        this.hotCustomers = hotCustomers;
        this.closedDeals = closedDeals;
    }

    public long getTotalLeads() {
        return totalLeads;
    }

    public void setTotalLeads(long totalLeads) {
        this.totalLeads = totalLeads;
    }

    public long getTodayFollowUps() {
        return todayFollowUps;
    }

    public void setTodayFollowUps(long todayFollowUps) {
        this.todayFollowUps = todayFollowUps;
    }

    public long getPendingFollowUps() {
        return pendingFollowUps;
    }

    public void setPendingFollowUps(long pendingFollowUps) {
        this.pendingFollowUps = pendingFollowUps;
    }

    public long getHotCustomers() {
        return hotCustomers;
    }

    public void setHotCustomers(long hotCustomers) {
        this.hotCustomers = hotCustomers;
    }

    public long getClosedDeals() {
        return closedDeals;
    }

    public void setClosedDeals(long closedDeals) {
        this.closedDeals = closedDeals;
    }
    public Map<String, Long> getStatusCounts() {
        return statusCounts;
    }

    public void setStatusCounts(Map<String, Long> statusCounts) {
        this.statusCounts = statusCounts;
    }

    public Map<String, Long> getPriorityCounts() {
        return priorityCounts;
    }

    public void setPriorityCounts(Map<String, Long> priorityCounts) {
        this.priorityCounts = priorityCounts;
    }
}