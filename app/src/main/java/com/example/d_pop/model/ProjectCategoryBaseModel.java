package com.example.d_pop.model;

public class ProjectCategoryBaseModel {
    private String[] categories;


    public ProjectCategoryBaseModel(String[] categories) {
        this.categories = categories;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
