package com.example.practica1.Fragment;

import android.view.View;

import androidx.fragment.app.Fragment;

public abstract class QuestionFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_QUESTION = "question";
    public static final String ARG_ANSWER = "answer";

    public String question;
    public int correctAnswer;

    public View fragmentLayout;

    // Devuelve true si se ha introducido respuesta para la pregunta, false si no:
    public abstract boolean isAnswered();

    // Devuelve la respuesta introducida:
    public abstract int getAnswer();

    // Modifica la vista para mostrar la correccion de la pregunta:
    public abstract void ShowCorrection();


}
