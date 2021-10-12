package com.example.practica1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practica1.Adapter.Communicator;
import com.example.practica1.Adapter.ReviewAdapter;
import com.example.practica1.Data.Question;
import com.example.practica1.Data.QuestionDataBase;
import com.example.practica1.Fragment.QuestionFragment;
import com.example.practica1.R;

import java.util.List;

public class ResultsActivity extends AppCompatActivity { private TextView score;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private final List<Question> QuestList = Communicator.getList();
    private final List<QuestionFragment> QuestFragList = Communicator.getQFlist();
    private Button playAgain;
    private Button goStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Practica1_Dark);
        }else{
            setTheme(R.style.Theme_Practica1_Light);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        score=findViewById(R.id.result_score);
        score.setText(String.valueOf(Communicator.getHits()));
        recyclerView=findViewById(R.id.result_review_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ReviewAdapter(QuestList,QuestFragList);
        recyclerView.setAdapter(adapter);

        playAgain=findViewById(R.id.button_redoQuiz);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(ResultsActivity.this, QuizActivity.class));
            }
        });

        goStart=findViewById(R.id.button_goStart);
        goStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(ResultsActivity.this, MainActivity.class));
            }
        });

    }
}