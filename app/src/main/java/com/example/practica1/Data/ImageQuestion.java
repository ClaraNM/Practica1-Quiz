package com.example.practica1.Data;

public class ImageQuestion extends Question {

    private final int imageQuestionId;
    private final String op1, op2, op3, op4;

    public ImageQuestion(String question, String op1, String op2, String op3, String op4, int correctAnswer, int imageQuestionId) {
        super(question, correctAnswer);
        this.imageQuestionId = imageQuestionId;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
    }

    public int getImageQuestionId() {
        return imageQuestionId;
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
