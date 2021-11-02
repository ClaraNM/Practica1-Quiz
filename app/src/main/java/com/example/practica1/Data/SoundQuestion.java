package com.example.practica1.Data;

public class SoundQuestion extends Question {

    private int soundQuestionId;
    private String op1, op2, op3, op4;
    public SoundQuestion(int id, String question, String op1, String op2, String op3, String op4, int correctAnswer, int soundQuestionId) {
        super(id, question, correctAnswer);
        this.soundQuestionId = soundQuestionId;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
    }

    public void setSoundQuestionId(int soundQuestionId) {
        this.soundQuestionId = soundQuestionId;
    }

    public int getSoundQuestionId() {
        return soundQuestionId;
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
