package com.example.practica1.Data;

public class ImageQuestion extends Question {

    private int imageQuestionId;
    private String op1, op2, op3, op4;

    public ImageQuestion(int id, String question, String op1, String op2, String op3, String op4, int correctAnswer, int imageQuestionId) {
        super(id,question, correctAnswer);
        this.imageQuestionId = imageQuestionId;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
    }

    public int getImageQuestionId() {
        return imageQuestionId;
    }

    public void setImageQuestionId(int imageQuestionId) {
        this.imageQuestionId = imageQuestionId;
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
    public void setOp1(String s){this.op1=s;}
    public void setOp2(String s){this.op2=s;}
    public void setOp3(String s){this.op3=s;}
    public void setOp4(String s){this.op4=s;}
}
