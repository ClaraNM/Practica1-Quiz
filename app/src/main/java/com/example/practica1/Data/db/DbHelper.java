package com.example.practica1.Data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="questions.db";
    public static final String TABLE_QUESTIONS="t_questions";
    public static final String TABLE_TEXT_QUESTIONS="t_text_questions";
    public static final String TABLE_NUMBER_QUESTIONS="t_number_questions";
    public static final String TABLE_IMAGE_OP_QUESTIONS="t_image_op_questions";
    public static final String TABLE_IMAGE_QUESTIONS="t_image_questions";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_QUESTIONS+"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "FtextQ_ID,"+
                "FnumberQ_ID,"+
                "FimgOpQ_ID,"+
                "FimgQ_ID,"+
                "FOREIGN KEY (FtextQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(textQ_ID),"+
                "FOREIGN KEY (FnumberQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(numberQ_ID),"+
                "FOREIGN KEY (FimgOpQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(imgOpQ_ID),"+
                "FOREIGN KEY (FimgQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(imgQ_ID))"
                );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_TEXT_QUESTIONS+"("+
                "textQ_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "textQ_statement STRING NOT NULL,"+
                "textQ_op1 STRING NOT NULL,"+
                "textQ_op2 STRING NOT NULL,"+
                "textQ_op3 STRING NOT NULL,"+
                "textQ_op4 STRING NOT NULL,"+
                "textQ_correctAnswer INTEGER NOT NULL)"
                );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NUMBER_QUESTIONS+"("+
                "numberQ_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "numberQ_statement STRING NOT NULL,"+
                "numberQ_correctAnswer INTEGER NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_IMAGE_QUESTIONS+"("+
                "imgQ_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "imgQ_statement STRING NOT NULL,"+
                "imgQ_image INTEGER NOT NULL,"+
                "imgQ_op1 STRING NOT NULL,"+
                "imgQ_op2 STRING NOT NULL,"+
                "imgQ_op3 STRING NOT NULL,"+
                "imgQ_op4 STRING NOT NULL,"+
                "imgQ_correctAnswer INTEGER NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_IMAGE_OP_QUESTIONS+"("+
                "imgOpQ_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "imgOpQ_statement STRING NOT NULL,"+
                "imgOpQ_op1 INTEGER NOT NULL,"+
                "imgOpQ_op2 INTEGER NOT NULL,"+
                "imgOpQ_op3 INTEGER NOT NULL,"+
                "imgOpQ_op4 INTEGER NOT NULL,"+
                "imgOpQ_correctAnswer INTEGER NOT NULL)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_QUESTIONS);
        onCreate(sqLiteDatabase);

    }
}