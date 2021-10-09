package com.example.practica1.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.practica1.Data.ImageOptionsQuestion;
import com.example.practica1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageOptionsQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageOptionsQuestionFragment extends QuestionFragment {

    private int optionA;
    private int optionB;
    private int optionC;
    private int optionD;

    public static final String ARG_OP1 = "op1";
    public static final String ARG_OP2  = "op2";
    public static final String ARG_OP3  = "op3";
    public static final String ARG_OP4  = "op4";

    private int selectedImageIndex = -1;

    public ImageOptionsQuestionFragment() {
        // Required empty public constructor
    }
    public static ImageOptionsQuestionFragment newInstance(ImageOptionsQuestion question) {
        ImageOptionsQuestionFragment fragment = new ImageOptionsQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question.getQuestion());
        args.putInt(ARG_OP1, question.getImageId1());
        args.putInt(ARG_OP2, question.getImageId2());
        args.putInt(ARG_OP3, question.getImageId3());
        args.putInt(ARG_OP4, question.getImageId4());
        args.putInt(ARG_ANSWER, question.getCorrectAnswer());

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = getArguments().getString(ARG_QUESTION);
            optionA = getArguments().getInt(ARG_OP1);
            optionB = getArguments().getInt(ARG_OP2);
            optionC = getArguments().getInt(ARG_OP3);
            optionD = getArguments().getInt(ARG_OP4);
            correctAnswer = getArguments().getInt(ARG_ANSWER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_image_options_question, container, false);
        TextView textView = root.findViewById(R.id.imageoptionquestion_question_text);
        textView.setText(question);

        ImageButton ib1 = root.findViewById(R.id.image_option1);
        ib1.setImageResource(optionA);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 0;
            }
        });

        ImageButton ib2 = root.findViewById(R.id.image_option2);
        ib2.setImageResource(optionB);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 1;
            }
        });

        ImageButton ib3 = root.findViewById(R.id.image_option3);
        ib3.setImageResource(optionC);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 2;
            }
        });

        ImageButton ib4 = root.findViewById(R.id.image_option4);
        ib4.setImageResource(optionD);
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 3;
            }
        });


        return root;
    }

    @Override
    public boolean isAnswered() {
        return selectedImageIndex != -1;
    }

    @Override
    public int getAnswer() {
        return selectedImageIndex;
    }

    @Override
    public void ShowCorrection() {


    }

}