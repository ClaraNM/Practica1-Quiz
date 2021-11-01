package com.example.practica1.Data;

public class VideoQuestion extends Question {

    private final int videoQuestionId;
    private final String op1, op2, op3, op4;
    public VideoQuestion(int id, String question, String op1, String op2, String op3, String op4, int correctAnswer, int videoQuestionId) {
        super(id, question, correctAnswer);
        this.videoQuestionId = videoQuestionId;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
    }

    public int getVideoQuestionId() {
        return videoQuestionId;
    }

    public String getOp1() {
        return op1;
    }

    public String getOp2() {
        return op2;
    }

    public String getOp3() {
        return op3;
    }

    public String getOp4() {
        return op4;
    }
}
