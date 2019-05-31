package com.example.d_pop.model;

public class QueryAnswerModel {

    private String answeredBy;
    private String answer;

    public QueryAnswerModel(String answeredBy, String answer) {
        this.answeredBy = answeredBy;
        this.answer = answer;
    }

    public String getAnsweredBy() {
        return answeredBy;
    }

    public String getAnswer() {
        return answer;
    }
}
