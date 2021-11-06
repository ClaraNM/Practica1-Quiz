package com.example.practica1.Data;

public class VideoQuestion extends TextOptionQuestion {

    private int videoQuestionId;
    public VideoQuestion(int id, String question, String op1, String op2, String op3, String op4, int correctAnswer, int videoQuestionId, int dificulty, int theme) {
        super(id, question, op1, op2, op3, op4, correctAnswer,dificulty,theme);
        this.videoQuestionId = videoQuestionId;
    }

    public int getVideoQuestionId() {
        return videoQuestionId;
    }
    public void setVideoQuestionId(int n){ this.videoQuestionId=n;}


}
