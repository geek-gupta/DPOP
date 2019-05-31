package com.example.d_pop.model;

import java.util.ArrayList;

public class QueryModel {

    private String queryId;
    private String question;
    private String queryPostedBy;
    private String posterRollnumber;
    public ArrayList<String> images;
    public ArrayList<QueryAnswerModel> answers;


    public QueryModel(String posterRollnumber, String queryPostedBy, String queryId, String question, ArrayList<String> images, ArrayList<QueryAnswerModel> answers) {
        this.queryId = queryId;
        this.question = question;
        this.images = images;
        this.answers = answers;
        this.queryPostedBy = queryPostedBy;
        this.posterRollnumber  = posterRollnumber;
    }

    public String getQueryPostedBy() {
        return queryPostedBy;
    }

    public String getQueryId() {
        return queryId;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getImages() {
        return images;
    }

    public ArrayList<QueryAnswerModel> getAnswers() {
        return answers;
    }

    public String getPosterRollnumber() {
        return posterRollnumber;
    }
}
