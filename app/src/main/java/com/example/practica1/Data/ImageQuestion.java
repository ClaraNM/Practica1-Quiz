package com.example.practica1.Data;

public class ImageQuestion extends TextQuestion {

    private final int imageQuestionId;

    public ImageQuestion(String question, String op1, String op2, String op3, String op4, int correctAnswer, int imageQuestionId) {
        super(question, op1, op2, op3, op4, correctAnswer);
        this.imageQuestionId = imageQuestionId;
    }

    public int getImageQuestionId() {
        return imageQuestionId;
    }
}
