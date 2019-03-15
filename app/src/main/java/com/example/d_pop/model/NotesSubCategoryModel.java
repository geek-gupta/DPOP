package com.example.d_pop.model;

public class NotesSubCategoryModel {
    private String name, addedBy, addedOn, category, rating;

    public NotesSubCategoryModel(String name, String addedBy, String addedOn, String category, String rating) {
        this.name = name;
        this.addedBy = addedBy;
        this.addedOn = addedOn;
        this.category = category;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public String getAddedOn() {
        return addedOn;
    }

    public String getCategory() {
        return category;
    }

    public String getRating() {
        return rating;
    }
}
