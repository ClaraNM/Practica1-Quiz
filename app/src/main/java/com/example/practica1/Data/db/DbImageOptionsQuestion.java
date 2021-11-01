package com.example.practica1.Data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.practica1.Data.ImageOptionsQuestion;

public class DbImageOptionsQuestion extends DbHelper {
    Context context;

    public DbImageOptionsQuestion(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertImageOptionsQuestion(ImageOptionsQuestion question){
        long id=0;
        DbHelper dbHelper= new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("imgOpQ_statement",question.getQuestion());
        values.put("imgOpQ_op1",question.getImageId1());
        values.put("imgOpQ_op2",question.getImageId2());
        values.put("imgOpQ_op3",question.getImageId3());
        values.put("imgOpQ_op4",question.getImageId4());
        values.put("imgOpQ_correctAnswer",question.getCorrectAnswer());

        id=db.insert(TABLE_IMAGE_OP_QUESTIONS,null, values);
        return id;
    }
}
