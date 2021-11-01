package com.example.practica1.Data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.practica1.Data.ImageOptionsQuestion;
import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.NumberQuestion;
import com.example.practica1.Data.Question;
import com.example.practica1.Data.TextQuestion;

import java.util.ArrayList;
import java.util.List;

public class DbQuestion extends DbHelper{
    Context context;
    public DbQuestion(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public List<Question> getQuesionPool(int size){
        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        List<Question> questionList = new ArrayList<Question>();
        Cursor cursorQuestions = null;
        if (size==10){
            cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_QUESTIONS+" ORDER BY RANDOM() LIMIT 10", null);
        }else if(size==15){
            cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_QUESTIONS+" ORDER BY RANDOM() LIMIT 15", null);
        }else{
            for (int i = 0; i < size; i++) {
                //0->Pregunta de respuestas imagenes
                //1->Preguntas de texto
                //2->Preguntas de número
                //3->Preguntas de enunciado con imagen

                int randomTypeQ= (int) Math.floor(Math.random()*3);
                int randomQ= 0;
                switch (randomTypeQ){
                    case 0:
                        ImageOptionsQuestion question_IO =new ImageOptionsQuestion(0,null,0,0,0,0,0);
                        randomQ=(int)Math.floor(Math.random()*3);
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_IMAGE_OP_QUESTIONS+" WHERE imgOpQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_IO.setId(cursorQuestions.getInt(0));
                                question_IO.setQuestion(cursorQuestions.getString(1));
                                question_IO.setImageId1(cursorQuestions.getInt(2));
                                question_IO.setImageId2(cursorQuestions.getInt(3));
                                question_IO.setImageId3(cursorQuestions.getInt(4));
                                question_IO.setImageId4(cursorQuestions.getInt(5));
                                question_IO.setCorrectAnswer(cursorQuestions.getInt(6));

                                questionList.add(question_IO);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                    case 1:
                        TextQuestion question_T=new TextQuestion(0,null,null,null,null,null,0);
                        randomQ=(int)Math.floor(Math.random()*7);
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_TEXT_QUESTIONS+" WHERE textQ_ID = '"+randomQ+"'",null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_T.setId(cursorQuestions.getInt(0));
                                question_T.setQuestion(cursorQuestions.getString(1));
                                question_T.setOp1(cursorQuestions.getString(2));
                                question_T.setOp2(cursorQuestions.getString(3));
                                question_T.setOp3(cursorQuestions.getString(4));
                                question_T.setOp4(cursorQuestions.getString(5));
                                question_T.setCorrectAnswer(cursorQuestions.getInt(6));

                                questionList.add(question_T);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                    case 2:
                        NumberQuestion question_N= new NumberQuestion(0,null,0);
                        randomQ=(int)Math.floor(Math.random()*3);
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_NUMBER_QUESTIONS+" WHERE numberQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_N.setId(cursorQuestions.getInt(0));
                                question_N.setQuestion(cursorQuestions.getString(1));
                                question_N.setCorrectAnswer(cursorQuestions.getInt(2));

                                questionList.add(question_N);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                    case 3:
                        ImageQuestion question_I=new ImageQuestion(0,null,null,null,null,null,0,0);
                        randomQ=(int)Math.floor(Math.random()*3);
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_IMAGE_QUESTIONS+" WHERE imgQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_I.setId(cursorQuestions.getInt(0));
                                question_I.setQuestion(cursorQuestions.getString(1));
                                question_I.setOp1(cursorQuestions.getString(2));
                                question_I.setOp2(cursorQuestions.getString(3));
                                question_I.setOp3(cursorQuestions.getString(4));
                                question_I.setOp4(cursorQuestions.getString(5));
                                question_I.setCorrectAnswer(cursorQuestions.getInt(6));
                                question_I.setImageQuestionId(cursorQuestions.getInt(7));

                                questionList.add(question_I);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                }
            }

        }

return questionList;
    }
}
