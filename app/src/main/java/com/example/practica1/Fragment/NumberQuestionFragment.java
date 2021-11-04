package com.example.practica1.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practica1.Activities.QuizActivity;
import com.example.practica1.Data.NumberQuestion;
import com.example.practica1.R;

public class NumberQuestionFragment extends QuestionFragment {

    public NumberQuestionFragment() {
        // Required empty public constructor
    }

    public static NumberQuestionFragment newInstance(NumberQuestion question) {
        NumberQuestionFragment fragment = new NumberQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question.getQuestion());
        args.putInt(ARG_ANSWER, question.getCorrectAnswer());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = getArguments().getString(ARG_QUESTION);
            correctAnswer = getArguments().getInt(ARG_ANSWER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_number_question, container, false);
        TextView textView = root.findViewById(R.id.question_text);
        textView.setText(question);

        Button checkButton = root.findViewById(R.id.button_check);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isAnswered()){
                    boolean hit = getAnswer() == correctAnswer;
                    ((QuizActivity)getActivity()).CheckAndContinue(hit);
                }
            }
        });
        fragmentLayout = root;
        return  root;
    }

    @Override
    public boolean isAnswered() {
        EditText tv = fragmentLayout.findViewById(R.id.numberquestion_question_text);
        String s = tv.getText().toString();
        return !s.isEmpty() && !s.equals("");
    }

    @Override
    public int getAnswer() {
        EditText tv = fragmentLayout.findViewById(R.id.numberquestion_question_text);
        return Integer.parseInt(tv.getText().toString());
    }

    @Override
    public void ShowCorrection() {
        TextView tv = fragmentLayout.findViewById(R.id.numberquestion_result);
        tv.setText(correctAnswer + "");
        tv.setTextColor(Color.WHITE);
        if(getAnswer() == correctAnswer){
            tv.setBackgroundResource(R.drawable.radiobutton_right);
        }
        else{
            tv.setBackgroundResource(R.drawable.radiobutton_wrong);
        }
    }
}