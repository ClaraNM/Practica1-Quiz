package com.example.practica1.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.support.v4.media.session.MediaControllerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.practica1.Activities.MainActivity;
import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.VideoQuestion;
import com.example.practica1.R;

public class VideoQuestionFragment extends TextQuestionFragment {

    private int videoQuestionId;
    private VideoView video;
    public static final String ARG_VIDEOQUESTIONID  = "imageQuestionId";

    public VideoQuestionFragment() {

    }

    public static VideoQuestionFragment newInstance(VideoQuestion question) {
        VideoQuestionFragment fragment = new VideoQuestionFragment();
        Bundle args = new Bundle();
        setArgs(args, question);
        fragment.setArguments(args);
        return fragment;
    }

    protected static void setArgs(Bundle args, VideoQuestion question){
        args.putString(ARG_QUESTION, question.getQuestion());
        args.putInt(ARG_ANSWER, question.getCorrectAnswer());
        args.putString(ARG_OP1, question.getOp1());
        args.putString(ARG_OP2, question.getOp2());
        args.putString(ARG_OP3, question.getOp3());
        args.putString(ARG_OP4, question.getOp4());
        args.putInt(ARG_VIDEOQUESTIONID, question.getVideoQuestionId());
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
        videoQuestionId = getArguments().getInt(ARG_VIDEOQUESTIONID);
    }

    @Override
    protected int getFragmentLayoutId(){
        return R.layout.fragment_video_question;
    }
    @Override
    protected void setUpLayout(View root){

        super.setUpLayout(root);
        video = root.findViewById(R.id.video_question);
        String path = "android.resource://" + MainActivity.PACKAGE_NAME + "/" + videoQuestionId;
        Uri uri = Uri.parse(path);
        video.setVideoURI(uri);

        MediaController mediaController = new MediaController(this.getContext());
        video.setMediaController(mediaController);
        video.requestFocus();
        video.start();

    }

    @Override
    public int getAnswer(){
        video.pause();
        return super.getAnswer();
    }


}