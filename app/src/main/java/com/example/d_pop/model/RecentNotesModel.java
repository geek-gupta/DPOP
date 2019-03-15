package com.example.d_pop.model;

public class RecentNotesModel {
    private String recentNoteName;

    public String getRecentNoteName() {
        return recentNoteName;
    }

    public void setRecentNoteName(String recentNoteName) {
        this.recentNoteName = recentNoteName;
    }

    public RecentNotesModel(String recentNoteName) {
        this.recentNoteName = recentNoteName;
    }
}
