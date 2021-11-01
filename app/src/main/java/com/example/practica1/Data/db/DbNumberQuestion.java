package com.example.practica1.Data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.practica1.Data.NumberQuestion;
import com.example.practica1.Data.TextQuestion;

public class DbNumberQuestion extends DbHelper{
    Context context;

    public DbNumberQuestion(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertNumberQuestion(NumberQuestion question){
        long id=0;
        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("numberQ_statement",question.getQuestion());
        values.put("numberQ_correctAnswer",question.getCorrectAnswer());

        id=db.insert(TABLE_NUMBER_QUESTIONS,null, values);
        return id;
    }

}
