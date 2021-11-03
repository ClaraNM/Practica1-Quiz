package com.example.practica1.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.TextQuestion;
import com.example.practica1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImageQuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImageQuestionFragment extends TextQuestionFragment {

    private int imageQuestionId;

    public static final String ARG_IMAGEQUESTIONID  = "imageQuestionId";

    public ImageQuestionFragment() {

    }

    public static ImageQuestionFragment newInstance(ImageQuestion question) {
        ImageQuestionFragment fragment = new ImageQuestionFragment();
        Bundle args = new Bundle();
        setArgs(args, question);
        fragment.setArguments(args);
        return fragment;
    }

    protected static void setArgs(Bundle args, ImageQuestion question){
        args.putString(ARG_QUESTION, question.getQuestion());
        args.putInt(ARG_ANSWER, question.getCorrectAnswer());
        args.putString(ARG_OP1, question.getOp1());
        args.putString(ARG_OP2, question.getOp2());
        args.putString(ARG_OP3, question.getOp3());
        args.putString(ARG_OP4, question.getOp4());
        args.putInt(ARG_IMAGEQUESTIONID, question.getImageQuestionId());
    }

    @Override
    protected int getFragmentLayoutId(){
        return R.layout.fragment_image_question;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            loadArgs();
        }
    }

    @Override
    protected void loadArgs(){
        super.loadArgs();
        imageQuestionId = getArguments().getInt(ARG_IMAGEQUESTIONID);

    }
    @Override
    protected void setUpLayout(View root){
        super.setUpLayout(root);
        ImageView image = root.findViewById(R.id.image_question);
        image.setImageResource(imageQuestionId);
    }


}