package com.example.d_pop.model;

public class RecentNotesModel {
    private String[] recentNotesList;

    public String[] getRecentNoteName() {
        return recentNotesList;
    }


    public RecentNotesModel(String[] recentNoteName) {
        this.recentNotesList = recentNoteName;
    }
}
