package com.example.practica1.Data;

public abstract class Question {

    private int id;
    private String question;
    private int correctAnswer;
    public Question(int id,String question, int correctAnswer) {
        this.id=id;
        this.question = question;
        this.correctAnswer = correctAnswer;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getId() { return id; }
    public String getQuestion() {
        return question;
    }
    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
