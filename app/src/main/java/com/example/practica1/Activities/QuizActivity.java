package com.example.practica1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import com.example.practica1.Data.ImageOptionsQuestion;
import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.NumberQuestion;
import com.example.practica1.Data.Profile;
import com.example.practica1.Data.Question;
import com.example.practica1.Data.QuestionDataBase;
import com.example.practica1.Data.SoundQuestion;
import com.example.practica1.Data.TextQuestion;
import com.example.practica1.Data.VideoQuestion;
import com.example.practica1.Data.db.DbQuerys;
import com.example.practica1.Fragment.ImageOptionsQuestionFragment;
import com.example.practica1.Fragment.ImageQuestionFragment;
import com.example.practica1.Fragment.NumberQuestionFragment;
import com.example.practica1.Fragment.QuestionFragment;
import com.example.practica1.Fragment.SoundQuestionFragment;
import com.example.practica1.Fragment.TextQuestionFragment;
import com.example.practica1.Fragment.VideoQuestionFragment;
import com.example.practica1.R;
import com.example.practica1.Adapter.Communicator;

import java.util.List;
import java.util.Locale;
import java.util.Timer;

public class QuizActivity extends AppCompatActivity {

    // Total de preguntas de la ronda
    private final int poolSize = 5;

    // Lista de preguntas de la ronda
    private List<Question> questionList;

    // Indice de la pregunta actual
    private int currentQuestion = -1;
    private int hits = 0;
    private int fails = 0;
    // Marcador del número de pregunta
    private TextView tv_questionNumber;
    private TextView tv_hitCounter;
    private TextView tv_failCounter;
    private Chronometer chronometer;

    // Fragmento actual para visualizar la pregunta
    private QuestionFragment currentFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            setTheme(R.style.Theme_Practica1_Dark);
        }else{
            setTheme(R.style.Theme_Practica1_Light);
        }
        Communicator.setZero_QFList();
        Communicator.setZero_Hits();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Carga la lista de preguntas
        try {
            //Asegura que sale una lista con el tamaño pedido de preguntas
            do {
                questionList = QuestionDataBase.getQuestionPool(poolSize, QuizActivity.this);
            }while(questionList.size()<poolSize);
            Communicator.setList(questionList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Establece las referencias del layout
        tv_questionNumber = findViewById(R.id.question_number);
        tv_hitCounter = findViewById(R.id.tv_hitCounter);
        tv_failCounter = findViewById(R.id.tv_failCounter);
        chronometer = findViewById(R.id.chronometer);
        chronometer.start();

        // Carga la primera pregunta:

        goNextQuestion();
    }

    public void CheckAndContinue(boolean hit){
        if(hit){
            Communicator.addHit();
            hits++;
            tv_hitCounter.setText(""+hits);
        }
        else{
            fails++;
            tv_failCounter.setText(""+fails);
        }
        goNextQuestion();
    }


    // Cargar la siguiente pregunta
    private void goNextQuestion(){
        // Si no quedan preguntas se pasa a la pantalla de resultados
        currentQuestion++;
        if(currentQuestion >= questionList.size() || currentQuestion >= poolSize){
            long elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            System.out.println(elapsedMillis + "");
            DbQuerys dbQuerys = new DbQuerys(this);
            Profile profile=Communicator.getNewProfile();
            profile.setScore(Communicator.getHits());
            dbQuerys.insertProfile(profile);
            finish();
            startActivity(new Intent(QuizActivity.this, ResultsActivity.class));
        }

        // Si quedan, se carga la siguiente pregunta
        else{
            Question question = questionList.get(currentQuestion);
            if(question instanceof ImageOptionsQuestion){
                replaceFragment(ImageOptionsQuestionFragment.newInstance((ImageOptionsQuestion) question));
                Communicator.addFragment(currentFragment);
            }
            else if(question instanceof NumberQuestion){
                replaceFragment(NumberQuestionFragment.newInstance((NumberQuestion) question));
                Communicator.addFragment(currentFragment);
            }
            else if(question instanceof ImageQuestion){
                replaceFragment(ImageQuestionFragment.newInstance((ImageQuestion) question));
                Communicator.addFragment(currentFragment);
            }
            else if(question instanceof VideoQuestion){
                replaceFragment(VideoQuestionFragment.newInstance((VideoQuestion) question));
                Communicator.addFragment(currentFragment);
            }
            else if(question instanceof SoundQuestion){
                replaceFragment(SoundQuestionFragment.newInstance((SoundQuestion) question));
                Communicator.addFragment(currentFragment);
            }
            else if(question instanceof TextQuestion) {
                replaceFragment(TextQuestionFragment.newInstance((TextQuestion) question));
                Communicator.addFragment(currentFragment);
            }
        }
        tv_questionNumber.setText("" + (currentQuestion + 1) + "/" + poolSize);
    }

    // Remplaza el fragmento de layout de la pregunta
    private void replaceFragment(QuestionFragment fragment){
        currentFragment = fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }
}