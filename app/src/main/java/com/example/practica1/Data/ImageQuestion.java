package com.example.practica1.Data;

public class ImageQuestion extends TextOptionQuestion {

    private int imageQuestionId;

    public ImageQuestion(int id, String question,int imageQuestionId, String op1, String op2, String op3, String op4, int correctAnswer, int dificulty, int theme) {
        super(id, question, op1, op2, op3, op4, correctAnswer, dificulty, theme);
        this.imageQuestionId = imageQuestionId;
    }

    public int getImageQuestionId() {
        return imageQuestionId;
    }

    public void setImageQuestionId(int imageQuestionId) {
        this.imageQuestionId = imageQuestionId;
    }

}
