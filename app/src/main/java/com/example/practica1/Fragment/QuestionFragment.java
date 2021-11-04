package com.example.practica1.Fragment;

import android.os.CountDownTimer;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.example.practica1.Activities.QuizActivity;

public abstract class QuestionFragment extends Fragment {

    public static final String ARG_QUESTION = "question";
    public static final String ARG_ANSWER = "answer";
    boolean answered = false;

    public String question;
    public int correctAnswer;

    public View fragmentLayout;

    public abstract boolean isAnswered();

    public abstract int getAnswer();

    public abstract void ShowCorrection();

    public void correctionCorroutine(){
        if(answered)
            return;
        ShowCorrection();
        answered = true;
        long countDownTimeMillis = 1000;
        new CountDownTimer(countDownTimeMillis, countDownTimeMillis) {
            @Override
            public void onTick(long l) {
            }

            @Override
            public void onFinish() {
                boolean hit = getAnswer() == correctAnswer;
                ((QuizActivity)getActivity()).CheckAndContinue(hit);

            }
        }.start();
    }
}
