package com.example.practica1.Data;

public abstract class Question {

    private int id;
    private String question;
    private int correctAnswer;
    private int dificulty;
    private int theme;
    //dificulty-> 0 - normal, 1 - hard.
    //theme-> 0 - AAA, 1 - Indie, 2 - Industry
    public Question(int id,String question, int correctAnswer, int dificulty, int theme) {
        this.id=id;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.dificulty=dificulty;
        this.theme=theme;

    }

public void setDificulty(int d){this.dificulty=d;}

    public void setTheme(int theme) {
        this.theme = theme;
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

    public int getTheme() {
        return theme;
    }

    public int getDificulty() {
        return dificulty;
    }
}
