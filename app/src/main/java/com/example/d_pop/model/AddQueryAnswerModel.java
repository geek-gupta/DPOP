package com.example.d_pop.model;

public class AddQueryAnswerModel {
    private String queryId;
    private String answeredBy;
    private String answer;

    public AddQueryAnswerModel(String queryId, String answeredBy, String answer) {
        this.queryId = queryId;
        this.answeredBy = answeredBy;
        this.answer = answer;
    }

    public String getQueryId() {
        return queryId;
    }

    public String getAnsweredBy() {
        return answeredBy;
    }

    public String getAnswer() {
        return answer;
    }
}
