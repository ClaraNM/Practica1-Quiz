package com.example.practica1.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.practica1.Data.Question;
import com.example.practica1.R;
import com.example.practica1.Data.TextQuestion;

public class TextQuestionFragment extends QuestionFragment {

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    public static final String ARG_OP1 = "op1";
    public static final String ARG_OP2  = "op2";
    public static final String ARG_OP3  = "op3";
    public static final String ARG_OP4  = "op4";

    public TextQuestionFragment() {

    }

    public static TextQuestionFragment newInstance(TextQuestion question) {
        TextQuestionFragment fragment = new TextQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question.getQuestion());
        args.putInt(ARG_ANSWER, question.getCorrectAnswer());
        args.putString(ARG_OP1, question.getOp1());
        args.putString(ARG_OP2, question.getOp2());
        args.putString(ARG_OP3, question.getOp3());
        args.putString(ARG_OP4, question.getOp4());

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = getArguments().getString(ARG_QUESTION);
            optionA = getArguments().getString(ARG_OP1);
            optionB = getArguments().getString(ARG_OP2);
            optionC = getArguments().getString(ARG_OP3);
            optionD = getArguments().getString(ARG_OP4);
            correctAnswer = getArguments().getInt(ARG_ANSWER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_text_question, container, false);

        TextView textView = root.findViewById(R.id.question_text);
        textView.setText(question);

        TextView op1 = root.findViewById(R.id.option1);
        op1.setText(optionA);

        TextView op2 = root.findViewById(R.id.option2);
        op2.setText(optionB);

        TextView op3 = root.findViewById(R.id.option3);
        op3.setText(optionC);

        TextView op4 = root.findViewById(R.id.option4);
        op4.setText(optionD);

        fragmentLayout = root;
        return  root;
    }

    @Override
    public boolean isAnswered() {
        RadioGroup rg = fragmentLayout.findViewById(R.id.option_group);
        return rg.getCheckedRadioButtonId() != -1;
    }

    @Override
    public int getAnswer() {
        RadioGroup rg = fragmentLayout.findViewById(R.id.option_group);
        int id = rg.getCheckedRadioButtonId();
        View rb = rg.findViewById(id);
        return rg.indexOfChild(rb);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void ShowCorrection() {
        RadioGroup rg = fragmentLayout.findViewById(R.id.option_group);
        RadioButton rbselected = rg.findViewById(rg.getCheckedRadioButtonId());
        rbselected.setTextColor(Color.WHITE);
        rbselected.setBackgroundResource(R.drawable.radiobutton_wrong);
        RadioButton rbcorrect = (RadioButton) rg.getChildAt(correctAnswer);
        rbcorrect.setTextColor(Color.WHITE);
        rbcorrect.setBackgroundResource(R.drawable.radiobutton_right);

    }


}