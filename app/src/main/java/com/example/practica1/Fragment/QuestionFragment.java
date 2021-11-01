package com.example.practica1.Fragment;

import android.view.View;

import androidx.fragment.app.Fragment;

public abstract class QuestionFragment extends Fragment {

    public static final String ARG_QUESTION = "question";
    public static final String ARG_ANSWER = "answer";

    public String question;
    public int correctAnswer;

    public View fragmentLayout;

    public abstract boolean isAnswered();

    public abstract int getAnswer();

    public abstract void ShowCorrection();
}
