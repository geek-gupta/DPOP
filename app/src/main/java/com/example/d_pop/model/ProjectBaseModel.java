package com.example.d_pop.model;

public class ProjectBaseModel {

    private String projectName;
    private String ownerName;
    private String creationTime;
    private String shortDescription;
    private int progress;
    private boolean isFav;
    private String projectType;

    public ProjectBaseModel(String projectName, String ownerName, String creationTime, String shortDescription, int progress, boolean isFav, String projectType) {
        this.projectName = projectName;
        this.ownerName = ownerName;
        this.creationTime = creationTime;
        this.shortDescription = shortDescription;
        this.progress = progress;
        this.isFav = isFav;
        this.projectType = projectType;
    }

    public boolean isFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public boolean getIsFav() {
        return isFav;
    }

    public void setIsFav(boolean isFav) {
        this.isFav = isFav;
    }
}