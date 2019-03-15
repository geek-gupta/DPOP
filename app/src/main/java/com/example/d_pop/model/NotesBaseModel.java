package com.example.d_pop.model;

public class NotesBaseModel {

    private  String NotesCategoryName;


    public NotesBaseModel(String notesCategoryName) {
        NotesCategoryName = notesCategoryName;
    }

    public String getNotesCategoryName() {
        return NotesCategoryName;
    }

    public void setNotesCategoryName(String notesCategoryName) {
        NotesCategoryName = notesCategoryName;
    }
}
