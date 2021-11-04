package com.example.practica1.Data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbTables extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="quiz_database.db";
  // public static final String TABLE_QUESTIONS="t_questions";
    public static final String TABLE_TEXT_QUESTIONS="t_text_questions";
    public static final String TABLE_NUMBER_QUESTIONS="t_number_questions";
    public static final String TABLE_IMAGE_OP_QUESTIONS="t_image_op_questions";
    public static final String TABLE_IMAGE_QUESTIONS="t_image_questions";
    public static final String TABLE_SOUND_QUESTIONS="t_sound_questions";
    public static final String TABLE_VIDEO_QUESTIONS="t_video_questions";
    public static final String TABLE_RANKING="t_ranking";


    public DbTables(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_QUESTIONS+"("+
                "id INTEGER PRIMARY KEY,"+
                "FtextQ_ID,"+
                "FnumberQ_ID,"+
                "FimgOpQ_ID,"+
                "FimgQ_ID,"+
                "FOREIGN KEY (FtextQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(textQ_ID),"+
                "FOREIGN KEY (FnumberQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(numberQ_ID),"+
                "FOREIGN KEY (FimgOpQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(imgOpQ_ID),"+
                "FOREIGN KEY (FimgQ_ID) REFERENCES " + TABLE_TEXT_QUESTIONS+"(imgQ_ID))"
                );*/
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_TEXT_QUESTIONS+"("+
                "textQ_ID INTEGER PRIMARY KEY ,"+
                "textQ_statement STRING NOT NULL,"+
                "textQ_op1 STRING NOT NULL,"+
                "textQ_op2 STRING NOT NULL,"+
                "textQ_op3 STRING NOT NULL,"+
                "textQ_op4 STRING NOT NULL,"+
                "textQ_correctAnswer INTEGER NOT NULL)"
                );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NUMBER_QUESTIONS+"("+
                "numberQ_ID INTEGER PRIMARY KEY ,"+
                "numberQ_statement STRING NOT NULL,"+
                "numberQ_correctAnswer INTEGER NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_IMAGE_QUESTIONS+"("+
                "imgQ_ID INTEGER PRIMARY KEY ,"+
                "imgQ_statement STRING NOT NULL,"+
                "imgQ_image INTEGER NOT NULL,"+
                "imgQ_op1 STRING NOT NULL,"+
                "imgQ_op2 STRING NOT NULL,"+
                "imgQ_op3 STRING NOT NULL,"+
                "imgQ_op4 STRING NOT NULL,"+
                "imgQ_correctAnswer INTEGER NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_IMAGE_OP_QUESTIONS+"("+
                "imgOpQ_ID INTEGER PRIMARY KEY ,"+
                "imgOpQ_statement STRING NOT NULL,"+
                "imgOpQ_op1 INTEGER NOT NULL,"+
                "imgOpQ_op2 INTEGER NOT NULL,"+
                "imgOpQ_op3 INTEGER NOT NULL,"+
                "imgOpQ_op4 INTEGER NOT NULL,"+
                "imgOpQ_correctAnswer INTEGER NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_SOUND_QUESTIONS+"("+
                "soundQ_ID INTEGER PRIMARY KEY ,"+
                "soundQ_statement STRING NOT NULL,"+
                "soundQ_sound INTEGER NOT NULL,"+
                "soundQ_op1 STRING NOT NULL,"+
                "soundQ_op2 STRING NOT NULL,"+
                "soundQ_op3 STRING NOT NULL,"+
                "soundQ_op4 STRING NOT NULL,"+
                "soundQ_correctAnswer INTEGER NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_VIDEO_QUESTIONS+"("+
                "videoQ_ID INTEGER PRIMARY KEY ,"+
                "videoQ_statement STRING NOT NULL,"+
                "videoQ_video NOT NULL,"+
                "videoQ_op1 STRING NOT NULL,"+
                "videoQ_op2 STRING NOT NULL,"+
                "videoQ_op3 STRING NOT NULL,"+
                "videoQ_op4 STRING NOT NULL,"+
                "videoQ_correctAnswer INTEGER NOT NULL)"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_RANKING+"("+
                "profile_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "profile_name STRING NOT NULL," +
                "profile_score INTEGER NOT NULL" +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_TEXT_QUESTIONS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_NUMBER_QUESTIONS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_IMAGE_QUESTIONS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_IMAGE_OP_QUESTIONS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_SOUND_QUESTIONS);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_VIDEO_QUESTIONS);

        onCreate(sqLiteDatabase);

    }
}
