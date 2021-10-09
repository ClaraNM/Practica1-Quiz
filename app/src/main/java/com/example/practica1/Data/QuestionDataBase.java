package com.example.practica1.Data;

import com.example.practica1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionDataBase {

    private static List<Question> questionList;

    public static List<Question> getQuestionPool(int size) throws Exception {

        if(size > questionList.size())
            throw new Exception();
        else if (size == questionList.size())
            return  questionList;
        else{
            Random random = new Random();
            List<Question> questions = new ArrayList<Question>(size);
            List<Question> questionPool = new ArrayList<Question>(questionList);
            for (int i = 0; i < size; i++){
                questions.add(questionPool.remove(random.nextInt(questionList.size() - i)));
            }
            return questions;
        }
    }

    public static void InitializeDataBase(){

        questionList = new ArrayList<>();

        questionList.add(new TextQuestion("Q1", "A1", "A2", "A3", "A4", 0));
        questionList.add(new TextQuestion("Q2", "B1", "B2", "B3", "B4", 1));
        questionList.add(new TextQuestion("Q3", "C1", "C2", "C3", "C4", 2));
        questionList.add(new TextQuestion("Q4", "D1", "D2", "D3", "D4", 3));
        questionList.add(new TextQuestion("Q5", "E1", "E2", "E3", "E4", 0));
        questionList.add(new TextQuestion("Q6", "F1", "F2", "F3", "F4", 1));
        questionList.add(new TextQuestion("Q7", "G1", "G2", "G3", "G4", 2));
        questionList.add(new TextQuestion("Q8", "H1", "H2", "H3", "H4", 3));

        questionList.add(new ImageOptionsQuestion("Q9", R.drawable.perro1, R.drawable.perro2, R.drawable.perro3, R.drawable.perro4, 0));
        questionList.add(new ImageOptionsQuestion("Q10", R.drawable.perro1, R.drawable.perro2, R.drawable.perro3, R.drawable.perro4,  1));
        questionList.add(new ImageOptionsQuestion("Q11", R.drawable.perro1, R.drawable.perro2, R.drawable.perro3, R.drawable.perro4,  2));
        questionList.add(new ImageOptionsQuestion("Q12", R.drawable.perro1, R.drawable.perro2, R.drawable.perro3, R.drawable.perro4,  3));

        questionList.add(new NumberQuestion("Q13", 24));
        questionList.add(new NumberQuestion("Q14", 145));
        questionList.add(new NumberQuestion("Q15", 3));
        questionList.add(new NumberQuestion("Q16", 89));
    }
}
