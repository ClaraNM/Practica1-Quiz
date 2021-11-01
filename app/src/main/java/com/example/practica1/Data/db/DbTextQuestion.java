package com.example.practica1.Data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.practica1.Data.TextQuestion;

public class DbTextQuestion extends DbHelper{
    Context context;

    public DbTextQuestion(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertTextQuestion(TextQuestion question){
        long id=0;
        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("textQ_statement",question.getQuestion());
        values.put("textQ_op1",question.getOp1());
        values.put("textQ_op2",question.getOp2());
        values.put("textQ_op3",question.getOp3());
        values.put("textQ_op4",question.getOp4());
        values.put("textQ_correctAnswer",question.getCorrectAnswer());

        id=db.insert(TABLE_TEXT_QUESTIONS,null, values);
        return id;
    }
}
