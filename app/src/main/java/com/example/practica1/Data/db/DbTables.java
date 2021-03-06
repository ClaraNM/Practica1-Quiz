package com.example.practica1.Data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.sql.Date;

public class DbTables extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="quiz_database.db";
    public static final String TABLE_TEXT_QUESTIONS="t_text_questions";
    public static final String TABLE_NUMBER_QUESTIONS="t_number_questions";
    public static final String TABLE_IMAGE_OP_QUESTIONS="t_image_op_questions";
    public static final String TABLE_IMAGE_QUESTIONS="t_image_questions";
    public static final String TABLE_SOUND_QUESTIONS="t_sound_questions";
    public static final String TABLE_VIDEO_QUESTIONS="t_video_questions";
    public static final String TABLE_RANKING="t_ranking";
    public static final String TABLE_PROFILES="t_profiles";


    public DbTables(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_TEXT_QUESTIONS+"("+
                "textQ_ID INTEGER PRIMARY KEY ,"+
                "textQ_statement STRING NOT NULL,"+
                "textQ_op1 STRING NOT NULL,"+
                "textQ_op2 STRING NOT NULL,"+
                "textQ_op3 STRING NOT NULL,"+
                "textQ_op4 STRING NOT NULL,"+
                "textQ_correctAnswer INTEGER NOT NULL," +
                "textQ_dificulty INTEGER NOT NULL,"+
                "textQ_theme INTEGER NOT NULL"+
                ")"

                );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NUMBER_QUESTIONS+"("+
                "numberQ_ID INTEGER PRIMARY KEY ,"+
                "numberQ_statement STRING NOT NULL,"+
                "numberQ_correctAnswer INTEGER NOT NULL," +
                "numberQ_dificulty INTEGER NOT NULL,"+
                "numberQ_theme INTEGER NOT NULL"+
                ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_IMAGE_QUESTIONS+"("+
                "imgQ_ID INTEGER PRIMARY KEY ,"+
                "imgQ_statement STRING NOT NULL,"+
                "imgQ_image INTEGER NOT NULL,"+
                "imgQ_op1 STRING NOT NULL,"+
                "imgQ_op2 STRING NOT NULL,"+
                "imgQ_op3 STRING NOT NULL,"+
                "imgQ_op4 STRING NOT NULL,"+
                "imgQ_correctAnswer INTEGER NOT NULL,"+
                "imgQ_dificulty INTEGER NOT NULL,"+
                "imgQ_theme INTEGER NOT NULL"+
                ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_IMAGE_OP_QUESTIONS+"("+
                "imgOpQ_ID INTEGER PRIMARY KEY ,"+
                "imgOpQ_statement STRING NOT NULL,"+
                "imgOpQ_op1 INTEGER NOT NULL,"+
                "imgOpQ_op2 INTEGER NOT NULL,"+
                "imgOpQ_op3 INTEGER NOT NULL,"+
                "imgOpQ_op4 INTEGER NOT NULL,"+
                "imgOpQ_correctAnswer INTEGER NOT NULL," +
                "imgOpQ_dificulty INTEGER NOT NULL,"+
                "imgOpQ_theme INTEGER NOT NULL"+
                ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_SOUND_QUESTIONS+"("+
                "soundQ_ID INTEGER PRIMARY KEY ,"+
                "soundQ_statement STRING NOT NULL,"+
                "soundQ_sound INTEGER NOT NULL,"+
                "soundQ_op1 STRING NOT NULL,"+
                "soundQ_op2 STRING NOT NULL,"+
                "soundQ_op3 STRING NOT NULL,"+
                "soundQ_op4 STRING NOT NULL,"+
                "soundQ_correctAnswer INTEGER NOT NULL," +
                "soundQ_dificulty INTEGER NOT NULL,"+
                "soundQ_theme INTEGER NOT NULL"+")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_VIDEO_QUESTIONS+"("+
                "videoQ_ID INTEGER PRIMARY KEY ,"+
                "videoQ_statement STRING NOT NULL,"+
                "videoQ_video NOT NULL,"+
                "videoQ_op1 STRING NOT NULL,"+
                "videoQ_op2 STRING NOT NULL,"+
                "videoQ_op3 STRING NOT NULL,"+
                "videoQ_op4 STRING NOT NULL,"+
                "videoQ_correctAnswer INTEGER NOT NULL,"+
                "videoQ_dificulty INTEGER NOT NULL,"+
                "videoQ_theme INTEGER NOT NULL"+
                ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_RANKING+"("+
                "profile_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "profile_name STRING NOT NULL," +
                "profile_score INTEGER NOT NULL," +
                "profile_time STRING NOT NULL" +
                ")"
        );
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_PROFILES+"("+
                "profile_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "profile_name STRING NOT NULL," +
                "profile_pic_URI STRING NOT NULL," +
                "profile_total_games INTEGER," +
                "profile_max_score INTEGER," +
                "profile_date_last_game STRING" +
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

    public boolean UpdateAccountProfileData(String name, int num_games, int maxScore, String date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("profile_total_games", num_games);
        values.put("profile_max_score", maxScore);
        values.put("profile_date_last_game", date);
        Cursor cursor = db.rawQuery("Select * from " + TABLE_PROFILES + " where profile_name = ?", new String[] { name} );
        if(cursor.getCount() > 0) {
            long res = db.update(TABLE_PROFILES, values, "profile_name=?", new String[]{name});
            if (res == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }

    public boolean DeleteAccountProfileData(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + TABLE_PROFILES + " where profile_name = ?", new String[] { name} );
        if(cursor.getCount() > 0) {
            long res = db.delete(TABLE_PROFILES, "profile_name=?", new String[]{name});
            if (res == -1)
                return false;
            else
                return true;
        }
        else
            return false;
    }
}
