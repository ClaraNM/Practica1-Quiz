package com.example.practica1.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.practica1.Data.QuestionDataBase;
import com.example.practica1.R;

public class MainActivity extends AppCompatActivity {

    //Buttons:
    private Button play_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QuestionDataBase.InitializeDataBase();

        play_button = findViewById(R.id.button_startQuiz);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });




    }
}