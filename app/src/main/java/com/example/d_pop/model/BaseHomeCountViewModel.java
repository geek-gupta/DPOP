package com.example.d_pop.model;

public class BaseHomeCountViewModel {

    private String countItemNameText;
    private String countItemtext;

    public BaseHomeCountViewModel(String countItemNameText, String countItemtext) {
        this.countItemNameText = countItemNameText;
        this.countItemtext = countItemtext;
    }


    public String getCountItemNameText() {
        return countItemNameText;
    }

    public void setCountItemNameText(String countItemNameText) {
        this.countItemNameText = countItemNameText;
    }

    public String getCountItemtext() {
        return countItemtext;
    }

    public void setCountItemtext(String countItemtext) {
        this.countItemtext = countItemtext;
    }
}
