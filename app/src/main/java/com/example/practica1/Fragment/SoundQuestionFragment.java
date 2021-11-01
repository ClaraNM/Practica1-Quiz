package com.example.practica1.Fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.support.v4.media.session.MediaControllerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.practica1.Activities.MainActivity;
import com.example.practica1.Data.SoundQuestion;
import com.example.practica1.Data.VideoQuestion;
import com.example.practica1.R;

import java.util.concurrent.TimeUnit;

public class SoundQuestionFragment extends QuestionFragment {

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private int soundQuestionId;

    public static final String ARG_OP1 = "op1";
    public static final String ARG_OP2  = "op2";
    public static final String ARG_OP3  = "op3";
    public static final String ARG_OP4  = "op4";
    public static final String ARG_SOUNDQUESTIONID  = "imageQuestionId";

    public SoundQuestionFragment() {

    }

    public static SoundQuestionFragment newInstance(SoundQuestion question) {
        SoundQuestionFragment fragment = new SoundQuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_QUESTION, question.getQuestion());
        args.putInt(ARG_ANSWER, question.getCorrectAnswer());
        args.putString(ARG_OP1, question.getOp1());
        args.putString(ARG_OP2, question.getOp2());
        args.putString(ARG_OP3, question.getOp3());
        args.putString(ARG_OP4, question.getOp4());
        args.putInt(ARG_SOUNDQUESTIONID, question.getSoundQuestionId());

        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = getArguments().getString(ARG_QUESTION);
            soundQuestionId = getArguments().getInt(ARG_SOUNDQUESTIONID);
            optionA = getArguments().getString(ARG_OP1);
            optionB = getArguments().getString(ARG_OP2);
            optionC = getArguments().getString(ARG_OP3);
            optionD = getArguments().getString(ARG_OP4);
            correctAnswer = getArguments().getInt(ARG_ANSWER);        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_sound_question, container, false);

        TextView textView = root.findViewById(R.id.question_text);
        textView.setText(question);

        ////////////////////////////////////////////////////////

        TextView player_current_time, player_total_time;
        SeekBar seekBar;
        ImageView btn_rew, btn_play, btn_pause, btn_ff;

        Handler handler = new Handler();
        player_current_time = root.findViewById(R.id.tv_current_time);
        player_total_time = root.findViewById(R.id.tv_total_time);
        seekBar = root.findViewById(R.id.seek_bar);
        btn_rew = root.findViewById(R.id.btn_rew);
        btn_play = root.findViewById(R.id.btn_play);
        btn_pause = root.findViewById(R.id.btn_pause);
        btn_ff = root.findViewById(R.id.btn_ff);
        MediaPlayer mediaplayer = MediaPlayer.create(this.getContext(), soundQuestionId);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaplayer.getCurrentPosition());
                handler.postDelayed(this, 300);

            }
        };

        int duration_int = mediaplayer.getDuration();
        String duration_str = setTimeFormat(duration_int);
        player_total_time.setText(duration_str);

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_play.setVisibility(View.GONE);
                btn_pause.setVisibility(View.VISIBLE);
                mediaplayer.start();
                seekBar.setMax(mediaplayer.getDuration());
                handler.postDelayed(runnable, 0);
            }
        });

        btn_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_play.setVisibility(View.VISIBLE);
                btn_pause.setVisibility(View.GONE);
                mediaplayer.pause();
                handler.removeCallbacks(runnable);
            }
        });

        btn_ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPos = mediaplayer.getCurrentPosition();
                int dur = mediaplayer.getDuration();

                if(mediaplayer.isPlaying() && dur != currentPos){
                    currentPos = currentPos + 5000;
                }
                String current_str = setTimeFormat(currentPos);
                player_current_time.setText(current_str);
                mediaplayer.seekTo(currentPos);
            }
        });

        btn_rew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPos = mediaplayer.getCurrentPosition();
                if(mediaplayer.isPlaying() && currentPos > 5000){
                    currentPos = currentPos - 5000;
                }
                String current_str = setTimeFormat(currentPos);
                player_current_time.setText(current_str);
                mediaplayer.seekTo(currentPos);

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b){
                    mediaplayer.seekTo(i);
                }
                player_current_time.setText(setTimeFormat(mediaplayer.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                btn_pause.setVisibility(View.GONE);
                btn_play.setVisibility(View.VISIBLE);
                mediaplayer.seekTo(0);

            }
        });

        ///////////////////////////////////////////////////////

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

    private String setTimeFormat(int time){
        String str = String.format("%02d:%02d", time / 60000, (time / 1000) % 60);
        return str;
    }
}