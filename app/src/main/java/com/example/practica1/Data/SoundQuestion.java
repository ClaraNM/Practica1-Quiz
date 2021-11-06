package com.example.practica1.Data;

public class SoundQuestion extends TextOptionQuestion {

    private int soundQuestionId;

    public SoundQuestion(int id, String question, String op1, String op2, String op3, String op4, int correctAnswer, int soundQuestionId,  int dificulty, int theme) {
        super(id, question, op1, op2, op3, op4, correctAnswer,dificulty,theme);
        this.soundQuestionId = soundQuestionId;
    }

    public void setSoundQuestionId(int soundQuestionId) {
        this.soundQuestionId = soundQuestionId;
    }

    public int getSoundQuestionId() {
        return soundQuestionId;
    }
}
