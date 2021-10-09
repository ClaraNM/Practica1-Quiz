package com.example.practica1.Data;

public abstract class Question {

    public Question(String question, int correctAnswer) {
        this.question = question;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    private String question;
    private int correctAnswer;

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
