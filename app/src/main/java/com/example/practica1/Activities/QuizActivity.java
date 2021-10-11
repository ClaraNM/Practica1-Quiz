package com.example.practica1.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica1.Data.ImageOptionsQuestion;
import com.example.practica1.Data.NumberQuestion;
import com.example.practica1.Data.Question;
import com.example.practica1.Data.QuestionDataBase;
import com.example.practica1.Data.TextQuestion;
import com.example.practica1.Fragment.ImageOptionsQuestionFragment;
import com.example.practica1.Fragment.NumberQuestionFragment;
import com.example.practica1.Fragment.QuestionFragment;
import com.example.practica1.Fragment.TextQuestionFragment;
import com.example.practica1.R;
import com.example.practica1.Adapter.Communicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    // Total de preguntas de la ronda
    private final int poolSize = 5;

    // Lista de preguntas de la ronda
    private List<Question> questionList;

    // Indice de la pregunta actual
    private int currentQuestion = -1;

    // Verdadero si se ha comprobado ya la pregunta actual
    private boolean questionChecked;

    // Botón de comprobar / avanzar pregunta
    private Button button_continue;

    // Marcador del número de pregunta
    private TextView questionNumber;

    // Fragmento actual para visualizar la pregunta
    private QuestionFragment currentFragment;


    // Notificacion si se deja una pregunta sin responder
    private Toast advice;

    private CountDownTimer countDownTimer;
    private TextView countDown;
    private long countDownTimeMillis;
    private final long startTime = 60000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Carga la lista de preguntas
        try {
            questionList = QuestionDataBase.getQuestionPool(poolSize);
            Communicator.setList(questionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        advice = Toast.makeText(getApplicationContext(), "Selecciona una opción", Toast.LENGTH_LONG);

        // Establece las referencias del layout
        questionNumber = findViewById(R.id.question_number);
        button_continue = findViewById(R.id.button_continuar);
        countDown = findViewById(R.id.countdown);

        // Establece el método onclick del botón:
        button_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!questionChecked){
                    checkQuestion();
                    if (currentFragment.getAnswer()==questionList.get(currentQuestion).getCorrectAnswer()){
                        Communicator.addHit();
                    }
                }
                else{


                    goNextQuestion();
                }
            }
        });

        // Carga la primera pregunta:
        goNextQuestion();
    }

    // Comprobar si alguna opcion está marcada y si lo está corregir la pregunta
    private void checkQuestion(){
        if(currentFragment.isAnswered()){
            currentFragment.ShowCorrection();
            questionChecked = true;
            button_continue.setText("Siguiente");
        }
        else{
            advice.show();
        }
    }

    // Cargar la siguiente pregunta
    private void goNextQuestion(){
        // Si no quedan preguntas se pasa a la pantalla de resultados
        currentQuestion++;
        if(currentQuestion >= poolSize){
            finish();
            startActivity(new Intent(QuizActivity.this, ResultsActivity.class));
        }

        // Si quedan, se carga la siguiente pregunta
        else{
            StartCountDown();
            Question question = questionList.get(currentQuestion);
            if(question instanceof TextQuestion) {
                replaceFragment(TextQuestionFragment.newInstance((TextQuestion) question));
                Communicator.addFragment(currentFragment);
            }
            else if(question instanceof ImageOptionsQuestion){
                replaceFragment(ImageOptionsQuestionFragment.newInstance((ImageOptionsQuestion) question));
                Communicator.addFragment(currentFragment);
            }
            else if(question instanceof NumberQuestion){
                replaceFragment(NumberQuestionFragment.newInstance((NumberQuestion) question));
                Communicator.addFragment(currentFragment);
            }
        }
        questionChecked = false;
        button_continue.setText("Comprobar");
        questionNumber.setText("" + (currentQuestion + 1) + "/" + poolSize);
    }

    // Remplaza el fragmento de layout de la pregunta
    private void replaceFragment(QuestionFragment fragment){
        currentFragment = fragment;
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragmentContainerView, fragment);
        ft.commit();
    }

    private void StartCountDown(){
        countDownTimeMillis = startTime;
        countDownTimer = new CountDownTimer(countDownTimeMillis, 1000) {
            @Override
            public void onTick(long l) {
                countDownTimeMillis = l;
                updateCountDownDisplay();
            }

            @Override
            public void onFinish() {
                goNextQuestion();
            }
        }.start();
    }

    private void updateCountDownDisplay(){
        int minutes = (int) countDownTimeMillis / 60000;
        int seconds = (int) (countDownTimeMillis / 1000 ) % 60;
        String time = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        countDown.setText(time);
    }


}