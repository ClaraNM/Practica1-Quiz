package com.example.practica1.Fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.practica1.Activities.QuizActivity;
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
        ImageButton ib2 = root.findViewById(R.id.image_option2);
        ImageButton ib3 = root.findViewById(R.id.image_option3);
        ImageButton ib4 = root.findViewById(R.id.image_option4);

        CardView op1= root.findViewById(R.id.card_option1);
        CardView op2= root.findViewById(R.id.card_option2);
        CardView op3= root.findViewById(R.id.card_option3);
        CardView op4= root.findViewById(R.id.card_option4);

        op1.setCardBackgroundColor(Color.TRANSPARENT);
        op2.setCardBackgroundColor(Color.TRANSPARENT);
        op3.setCardBackgroundColor(Color.TRANSPARENT);
        op4.setCardBackgroundColor(Color.TRANSPARENT);

        ib1.setImageResource(optionA);
        ib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 0;
                boolean hit = selectedImageIndex == correctAnswer;
                ((QuizActivity)getActivity()).CheckAndContinue(hit);
                ShowCorrection();
            }
        });


        ib2.setImageResource(optionB);
        ib2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 1;
                boolean hit = selectedImageIndex == correctAnswer;
                ((QuizActivity)getActivity()).CheckAndContinue(hit);
                ShowCorrection();
            }
        });


        ib3.setImageResource(optionC);
        ib3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 2;
                boolean hit = selectedImageIndex == correctAnswer;
                ((QuizActivity)getActivity()).CheckAndContinue(hit);
                ShowCorrection();
            }
        });


        ib4.setImageResource(optionD);
        ib4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageIndex = 3;
                boolean hit = selectedImageIndex == correctAnswer;
                ((QuizActivity)getActivity()).CheckAndContinue(hit);
                ShowCorrection();
            }
        });

        fragmentLayout = root;
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
        CardView op1= this.fragmentLayout.findViewById(R.id.card_option1);
        CardView op2= this.fragmentLayout.findViewById(R.id.card_option2);
        CardView op3= fragmentLayout.findViewById(R.id.card_option3);
        CardView op4= fragmentLayout.findViewById(R.id.card_option4);
        switch (correctAnswer){
            case 0:
                op1.setCardBackgroundColor(Color.parseColor("#FF01949A"));
                break;
            case 1:
                op2.setCardBackgroundColor(Color.parseColor("#FF01949A"));
                break;
            case 2:
                op3.setCardBackgroundColor(Color.parseColor("#FF01949A"));
                break;
            case 3:
                op4.setCardBackgroundColor(Color.parseColor("#FF01949A"));
                break;
        }
        if (getAnswer()!=correctAnswer){
            switch (getAnswer()){
                case 0:
                    op1.setCardBackgroundColor(Color.parseColor("#FFDB1F48"));
                    break;
                case 1:
                    op2.setCardBackgroundColor(Color.parseColor("#FFDB1F48"));
                    break;
                case 2:
                    op3.setCardBackgroundColor(Color.parseColor("#FFDB1F48"));
                    break;
                case 3:
                    op4.setCardBackgroundColor(Color.parseColor("#FFDB1F48"));
                    break;
            }
        }
    }

}