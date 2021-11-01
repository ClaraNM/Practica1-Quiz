package com.example.practica1.Activities;



import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Switch;

import com.example.practica1.Data.QuestionDataBase;
import com.example.practica1.R;

public class MainActivity extends AppCompatActivity {

    public static String PACKAGE_NAME;
    //Buttons:
    private Button play_button;
    private Switch modeSw;
    private  ImageView img_title ;
    private  boolean theme=false; //false->Light true-> Dark
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        PACKAGE_NAME = getPackageName();

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Practica1_Dark);
            theme=true;
        }else{
            setTheme(R.style.Theme_Practica1_Light);
            theme=false;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_title=findViewById(R.id.main_title_img);
        if(theme ==true){
            img_title.setImageResource(R.drawable.main_title_img_dark);
        }else{
            img_title.setImageResource(R.drawable.main_title_img_light);
        }
        modeSw=findViewById(R.id.theme_mode);
        if (AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
            modeSw.setChecked(true);
        }
        modeSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }else{
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
            }
        });

        QuestionDataBase.InitializeDataBase(MainActivity.this);

        play_button = findViewById(R.id.button_startQuiz);
        play_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(MainActivity.this, QuizActivity.class));
            }
        });




    }
}