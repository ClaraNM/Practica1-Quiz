package com.example.practica1.Data.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.practica1.Data.ImageOptionsQuestion;
import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.NumberQuestion;
import com.example.practica1.Data.Question;
import com.example.practica1.Data.SoundQuestion;
import com.example.practica1.Data.TextQuestion;
import com.example.practica1.Data.VideoQuestion;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class DbQuerys extends DbTables {
    Context context;
    private SQLiteDatabase db;
    private DbTables helper;

    public DbQuerys(@Nullable Context context) {
        super(context);
        this.context=context;
        this.helper = new DbTables(context);
        this.db = this.helper.getWritableDatabase();
    }

    public void insertTextQuestion(TextQuestion question){
        db.execSQL("INSERT INTO " +TABLE_TEXT_QUESTIONS+
                " (textQ_ID,textQ_statement,textQ_op1,textQ_op2,textQ_op3,textQ_op4,textQ_correctAnswer) " +
                " SELECT * FROM (SELECT '"+question.getId()+"' AS textQ_ID,'"+question.getQuestion()+"' AS textQ_statement,'"+question.getOp1()+"' AS textQ_op1," +
                "'"+question.getOp2()+"' AS textQ_op2,'"+question.getOp3()+"' AS textQ_op3,'"+question.getOp4()+"' AS textQ_op4," +
                "'"+question.getCorrectAnswer()+"' AS textQ_correctAnswer) AS temp\n" +
                " WHERE NOT EXISTS (\n" +
                "    SELECT textQ_ID FROM "+ TABLE_TEXT_QUESTIONS +" WHERE textQ_ID = '"+question.getId()+"'\n" +
                ") LIMIT 1");

    }

    public void insertNumberQuestion(NumberQuestion question){
        db.execSQL("INSERT INTO " +TABLE_NUMBER_QUESTIONS+
                " (numberQ_ID,numberQ_statement,numberQ_correctAnswer) SELECT * FROM (SELECT '"+question.getId()+"' AS numberQ_ID," +
                "'"+question.getQuestion()+"' AS numberQ_statement,'"+question.getCorrectAnswer()+"' AS numberQ_correctAnswer) AS temp\n" +
                " WHERE NOT EXISTS (\n" +
                " SELECT numberQ_ID FROM "+ TABLE_NUMBER_QUESTIONS +" WHERE numberQ_ID = '"+question.getId()+"'\n" +
                ") LIMIT 1");

    }

    public void insertImageQuestion(ImageQuestion question){
        db.execSQL("INSERT INTO " +TABLE_IMAGE_QUESTIONS+
                " (imgQ_ID,imgQ_statement,imgQ_image,imgQ_op1,imgQ_op2,imgQ_op3,imgQ_op4,imgQ_correctAnswer) " +
                " SELECT * FROM (SELECT '"+question.getId()+"' AS imgQ_ID, '"+question.getQuestion()+"' AS imgQ_statement," +
                "'"+question.getImageQuestionId()+"' AS imgQ_image,'"+question.getOp1()+"' AS imgQ_op1, +\n" +
                "'"+question.getOp2()+"' AS imgQ_op2,'"+question.getOp3()+"' AS imgQ_op3,'"+question.getOp4()+"' AS imgQ_op4, +\n" +
                "'"+question.getCorrectAnswer()+"' AS imgQ_correctAnswer) AS temp\n" +
                " WHERE NOT EXISTS (\n" +
                " SELECT imgQ_ID FROM "+ TABLE_IMAGE_QUESTIONS +" WHERE imgQ_ID = '"+question.getId()+"'\n" +
                ") LIMIT 1");
    }
    public void insertImageOptionsQuestion(ImageOptionsQuestion question){
        db.execSQL("INSERT INTO " +TABLE_IMAGE_OP_QUESTIONS+
                " (imgOpQ_ID,imgOpQ_statement,imgOpQ_op1,imgOpQ_op2,imgOpQ_op3,imgOpQ_op4,imgOpQ_correctAnswer) " +
                " SELECT * FROM (SELECT '"+question.getId()+"' AS imgOpQ_ID, '"+question.getQuestion()+"' AS imgOpQ_statement,'"+question.getImageId1()+"' AS imgOpQ_op1," +
                "'"+question.getImageId2()+"' AS imgOpQ_op2,'"+question.getImageId3()+"' AS imgOpQ_op3,'"+question.getImageId4()+"' AS imgOpQ_op4," +
                "'"+question.getCorrectAnswer()+"' AS imgOpQ_correctAnswer) AS temp\n" +
                " WHERE NOT EXISTS (\n" +
                "    SELECT imgOpQ_ID FROM "+ TABLE_IMAGE_OP_QUESTIONS +" WHERE imgOpQ_ID = '"+question.getId()+"'\n" +
                ") LIMIT 1");

    }
    /*
    public void insertSoundQuestion(SoundQuestion question){
        db.execSQL("INSERT INTO " +TABLE_SOUND_QUESTIONS+
                " (soundQ_ID,soundQ_statement,soundQ_op1,soundQ_op2,soundQ_op3,soundQ_op4,soundQ_correctAnswer, soundQ_sound) " +
                " SELECT * FROM (SELECT '"+question.getId()+"' AS soundQ_ID, '"+question.getQuestion()+"' AS soundQ_statement," +
                "'"+question.getSoundQuestionId()+"' AS soundQ_sound,'"+question.getOp1()+"' AS soundQ_op1," +
                "'"+question.getOp2()+"' AS soundQ_op2,'"+question.getOp3()+"' AS soundQ_op3,'"+question.getOp4()+"' AS soundQ_op4," +
                "'"+question.getCorrectAnswer()+"' AS soundQ_correctAnswer) AS temp\n" +
                " WHERE NOT EXISTS (\n" +
                "    SELECT soundQ_ID FROM "+ TABLE_SOUND_QUESTIONS +" WHERE soundQ_ID = '"+question.getId()+"'\n" +
                ") LIMIT 1");

    }*/
    /*
    public void insertVideoQuestion(VideoQuestion question){
        db.execSQL("INSERT INTO " +TABLE_VIDEO_QUESTIONS+
                " (videoQ_ID,videoQ_statement,videoQ_video,videoQ_op1,videoQ_op2,videoQ_op3,videoQ_op4,videoQ_correctAnswer) " +
                " SELECT * FROM (SELECT '"+question.getId()+"' AS videoQ_ID, '"+question.getQuestion()+"' AS videoQ_statement," +
                "'"+question.getVideoQuestionId()+"' AS videoQ_video,'"+question.getOp1()+"' AS videoQ_op1," +
                "'"+question.getOp2()+"' AS videoQ_op2,'"+question.getOp3()+"' AS videoQ_op3,'"+question.getOp4()+"' AS videoQ_op4," +
                "'"+question.getCorrectAnswer()+"' AS videoQ_correctAnswer) AS temp\n" +
                " WHERE NOT EXISTS (\n" +
                "    SELECT videoQ_ID FROM "+ TABLE_VIDEO_QUESTIONS +" WHERE videoQ_ID = '"+question.getId()+"'\n" +
                ") LIMIT 1");

    }
    */
    public List<Question> getQuestionPool(int size){
        Random random= new Random();

        List<Question> questionList = new ArrayList<Question>();

        Cursor cursorQuestions = null;
        //PRUEBA DE Q SE GUARDAN TODAS EN LA TABLA DE SUS PREGUNTAS
       /*
       List<Question> questionListPrueba = new ArrayList<Question>();
       TextQuestion question=new TextQuestion(0,null,null,null,null,null,0);
        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_TEXT_QUESTIONS , null);
        if (cursorQuestions.moveToFirst()){
            do {
                question.setId(cursorQuestions.getInt(0));
                question.setQuestion(cursorQuestions.getString(1));
                question.setOp1(cursorQuestions.getString(2));
                question.setOp2(cursorQuestions.getString(3));
                question.setOp3(cursorQuestions.getString(4));
                question.setOp4(cursorQuestions.getString(5));
                question.setCorrectAnswer(cursorQuestions.getInt(6));

                questionListPrueba.add(question);
            }while (cursorQuestions.moveToNext());
        }
        cursorQuestions.close();
        for (int i = 0; i < 8; i++) {
            Log.d("CREATION",questionListPrueba.get(i).getQuestion()+"/n");
        }
*/
        if (size==10){
            for (int i = 0; i < size; i++) {
                //0->Pregunta de respuestas imagenes
                //1->Preguntas de texto
                //2->Preguntas de número
                //3->Preguntas de enunciado con imagen
                //4->Preguntas de sonido
                //5->Preguntas de video

                int randomTypeQ= random.nextInt(6);
                int randomQ= 0;
                switch (randomTypeQ){
                    case 0:
                        ImageOptionsQuestion question_IO =new ImageOptionsQuestion(0,null,0,0,0,0,0);
                        randomQ=random.nextInt(4);
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
                        randomQ=random.nextInt(8);
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
                        randomQ=random.nextInt(4);
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
                        ImageQuestion question_I=new ImageQuestion(0,null,0,null,null,null,null,0);
                        randomQ=random.nextInt(4);
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_IMAGE_QUESTIONS+" WHERE imgQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_I.setId(cursorQuestions.getInt(0));
                                question_I.setQuestion(cursorQuestions.getString(1));
                                question_I.setImageQuestionId(cursorQuestions.getInt(2));
                                question_I.setOp1(cursorQuestions.getString(3));
                                question_I.setOp2(cursorQuestions.getString(4));
                                question_I.setOp3(cursorQuestions.getString(5));
                                question_I.setOp4(cursorQuestions.getString(6));
                                question_I.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_I);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                    case 4:
                        /*
                        SoundQuestion question_S=new SoundQuestion(0,null,null,null,null,null,0,0);
                        randomQ=0; //Como no hay varias por ahora aqui no hay random
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_SOUND_QUESTIONS+" WHERE soundQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_S.setId(cursorQuestions.getInt(0));
                                question_S.setQuestion(cursorQuestions.getString(1));
                                question_S.setSoundQuestionId(cursorQuestions.getInt(2));
                                question_S.setOp1(cursorQuestions.getString(3));
                                question_S.setOp2(cursorQuestions.getString(4));
                                question_S.setOp3(cursorQuestions.getString(5));
                                question_S.setOp4(cursorQuestions.getString(6));
                                question_S.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_S);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                         */
                    case 5:
                        /*
                        VideoQuestion question_V =new VideoQuestion(0,null,null,null,null,null,0,0);
                        randomQ=0;//Como no hay varias por ahora aqui no hay random
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_VIDEO_QUESTIONS+" WHERE videoQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_V.setId(cursorQuestions.getInt(0));
                                question_V.setQuestion(cursorQuestions.getString(1));
                                question_V.setVideoQuestionId(cursorQuestions.getInt(2));
                                question_V.setOp1(cursorQuestions.getString(3));
                                question_V.setOp2(cursorQuestions.getString(4));
                                question_V.setOp3(cursorQuestions.getString(5));
                                question_V.setOp4(cursorQuestions.getString(6));
                                question_V.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_V);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;

                         */
                }
            }

        }else if(size==15){
            for (int i = 0; i < size; i++) {
                //0->Pregunta de respuestas imagenes
                //1->Preguntas de texto
                //2->Preguntas de número
                //3->Preguntas de enunciado con imagen
                //4->Preguntas de sonido
                //5->Preguntas de video

                int randomTypeQ= random.nextInt(6);
                int randomQ= 0;
                switch (randomTypeQ){
                    case 0:
                        ImageOptionsQuestion question_IO =new ImageOptionsQuestion(0,null,0,0,0,0,0);
                        randomQ=random.nextInt(4);
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
                        randomQ=random.nextInt(8);
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
                        randomQ=random.nextInt(4);
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
                        ImageQuestion question_I=new ImageQuestion(0,null,0,null,null,null,null,0);
                        randomQ=random.nextInt(4);
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_IMAGE_QUESTIONS+" WHERE imgQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_I.setId(cursorQuestions.getInt(0));
                                question_I.setQuestion(cursorQuestions.getString(1));
                                question_I.setImageQuestionId(cursorQuestions.getInt(2));
                                question_I.setOp1(cursorQuestions.getString(3));
                                question_I.setOp2(cursorQuestions.getString(4));
                                question_I.setOp3(cursorQuestions.getString(5));
                                question_I.setOp4(cursorQuestions.getString(6));
                                question_I.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_I);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                    case 4:
                        /*
                        SoundQuestion question_S=new SoundQuestion(0,null,null,null,null,null,0,0);
                        randomQ=0; //Como no hay varias por ahora aqui no hay random
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_SOUND_QUESTIONS+" WHERE soundQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_S.setId(cursorQuestions.getInt(0));
                                question_S.setQuestion(cursorQuestions.getString(1));
                                question_S.setSoundQuestionId(cursorQuestions.getInt(2));
                                question_S.setOp1(cursorQuestions.getString(3));
                                question_S.setOp2(cursorQuestions.getString(4));
                                question_S.setOp3(cursorQuestions.getString(5));
                                question_S.setOp4(cursorQuestions.getString(6));
                                question_S.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_S);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;

                         */
                    case 5:
                        /*
                        VideoQuestion question_V =new VideoQuestion(0,null,null,null,null,null,0,0);
                        randomQ=0;//Como no hay varias por ahora aqui no hay random
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_VIDEO_QUESTIONS+" WHERE videoQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_V.setId(cursorQuestions.getInt(0));
                                question_V.setQuestion(cursorQuestions.getString(1));
                                question_V.setVideoQuestionId(cursorQuestions.getInt(2));
                                question_V.setOp1(cursorQuestions.getString(3));
                                question_V.setOp2(cursorQuestions.getString(4));
                                question_V.setOp3(cursorQuestions.getString(5));
                                question_V.setOp4(cursorQuestions.getString(6));
                                question_V.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_V);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;

                         */
                }
            }

        }else{
            for (int i = 0; i < size; i++) {
                //0->Pregunta de respuestas imagenes
                //1->Preguntas de texto
                //2->Preguntas de número
                //3->Preguntas de enunciado con imagen
                //4->Preguntas de sonido
                //5->Preguntas de video

                int randomTypeQ= random.nextInt(6);
                int randomQ= 0;
                switch (randomTypeQ){
                    case 0:
                        ImageOptionsQuestion question_IO =new ImageOptionsQuestion(0,null,0,0,0,0,0);
                        randomQ=random.nextInt(4);
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
                        randomQ=random.nextInt(8);
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
                        randomQ=random.nextInt(4);
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
                        ImageQuestion question_I=new ImageQuestion(0,null,0,null,null,null,null,0);
                        randomQ=random.nextInt(4);
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_IMAGE_QUESTIONS+" WHERE imgQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_I.setId(cursorQuestions.getInt(0));
                                question_I.setQuestion(cursorQuestions.getString(1));
                                question_I.setImageQuestionId(cursorQuestions.getInt(2));
                                question_I.setOp1(cursorQuestions.getString(3));
                                question_I.setOp2(cursorQuestions.getString(4));
                                question_I.setOp3(cursorQuestions.getString(5));
                                question_I.setOp4(cursorQuestions.getString(6));
                                question_I.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_I);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;
                    case 4:
                        /*
                        SoundQuestion question_S=new SoundQuestion(0,null,null,null,null,null,0,0);
                        randomQ=0; //Como no hay varias por ahora aqui no hay random
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_SOUND_QUESTIONS+" WHERE soundQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_S.setId(cursorQuestions.getInt(0));
                                question_S.setQuestion(cursorQuestions.getString(1));
                                question_S.setSoundQuestionId(cursorQuestions.getInt(2));
                                question_S.setOp1(cursorQuestions.getString(3));
                                question_S.setOp2(cursorQuestions.getString(4));
                                question_S.setOp3(cursorQuestions.getString(5));
                                question_S.setOp4(cursorQuestions.getString(6));
                                question_S.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_S);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;

                         */
                    case 5:
                        /*
                        VideoQuestion question_V =new VideoQuestion(0,null,null,null,null,null,0,0);
                        randomQ=0;//Como no hay varias por ahora aqui no hay random
                        cursorQuestions=db.rawQuery("SELECT * FROM "+TABLE_VIDEO_QUESTIONS+" WHERE videoQ_ID = '"+randomQ+"'", null);
                        if (cursorQuestions.moveToFirst()){
                            do {
                                question_V.setId(cursorQuestions.getInt(0));
                                question_V.setQuestion(cursorQuestions.getString(1));
                                question_V.setVideoQuestionId(cursorQuestions.getInt(2));
                                question_V.setOp1(cursorQuestions.getString(3));
                                question_V.setOp2(cursorQuestions.getString(4));
                                question_V.setOp3(cursorQuestions.getString(5));
                                question_V.setOp4(cursorQuestions.getString(6));
                                question_V.setCorrectAnswer(cursorQuestions.getInt(7));


                                questionList.add(question_V);
                            }while (cursorQuestions.moveToNext());
                        }
                        cursorQuestions.close();
                        break;

                         */
                }
            }

        }

return questionList;
    }
}
