package com.example.practica1.Data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.practica1.Data.ImageQuestion;
import com.example.practica1.Data.TextQuestion;

public class DbImageQuestion extends DbHelper{
    Context context;

    public DbImageQuestion(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertImageQuestion(ImageQuestion question){
        long id=0;
        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("imgQ_statement",question.getQuestion());
        values.put("imgQ_image",question.getImageQuestionId());
        values.put("imgQ_op1",question.getOp1());
        values.put("imgQ_op2",question.getOp2());
        values.put("imgQ_op3",question.getOp3());
        values.put("imgQ_op4",question.getOp4());
        values.put("imgQ_correctAnswer",question.getCorrectAnswer());

        id=db.insert(TABLE_IMAGE_QUESTIONS,null, values);
        return id;
    }
}
