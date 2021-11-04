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
import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.SoundQuestion;
import com.example.practica1.Data.VideoQuestion;
import com.example.practica1.R;

import java.util.concurrent.TimeUnit;

public class SoundQuestionFragment extends TextQuestionFragment {

    private int soundQuestionId;
    private MediaPlayer mediaplayer;

    public static final String ARG_SOUNDQUESTIONID  = "imageQuestionId";

    public SoundQuestionFragment() {

    }

    public static SoundQuestionFragment newInstance(SoundQuestion question) {
        SoundQuestionFragment fragment = new SoundQuestionFragment();
        Bundle args = new Bundle();
        setArgs(args, question);
        fragment.setArguments(args);
        return fragment;
    }

    protected static void setArgs(Bundle args, SoundQuestion question){
        args.putString(ARG_QUESTION, question.getQuestion());
        args.putInt(ARG_ANSWER, question.getCorrectAnswer());
        args.putString(ARG_OP1, question.getOp1());
        args.putString(ARG_OP2, question.getOp2());
        args.putString(ARG_OP3, question.getOp3());
        args.putString(ARG_OP4, question.getOp4());
        args.putInt(ARG_SOUNDQUESTIONID, question.getSoundQuestionId());
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
        soundQuestionId = getArguments().getInt(ARG_SOUNDQUESTIONID);
    }

    @Override
    protected int getFragmentLayoutId(){
        return R.layout.fragment_sound_question;
    }

    @Override
    protected void setUpLayout(View root){
        super.setUpLayout(root);

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
        mediaplayer = MediaPlayer.create(this.getContext(), soundQuestionId);

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
    }

    private String setTimeFormat(int time){
        String str = String.format("%02d:%02d", time / 60000, (time / 1000) % 60);
        return str;
    }

    @Override
    public int getAnswer(){
        mediaplayer.stop();
        return super.getAnswer();
    }

}