package com.example.labquiz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class QuizDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_QUESTIONS = "questions";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_TEXT = "text";
    private static final String COLUMN_CORRECT_ANSWER = "correct_answer";

    private static final String COLUMN_OPT1 = "opt1";
    private static final String COLUMN_OPT2 = "opt2";

    public QuizDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_QUESTIONS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEXT + " TEXT, " +
                COLUMN_CORRECT_ANSWER + " TEXT, " +
                COLUMN_OPT1+ " TEXT, "+
                COLUMN_OPT2+" TEXT)";
                ;
        db.execSQL(createTable);
    }
    public void insertQuestion(){

        Question q1=new Question("if permession","rachad","rachad","iii");
        this.insertQuestion(q1);
        Question q2=new Question("if permession","ahee","ooooo","iii");
        this.insertQuestion(q2);
        Question q3=new Question("if permession","ahee","ooooo","iii");
        this.insertQuestion(q3);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);
        onCreate(db);
    }

    public void insertQuestion(Question question) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TEXT, question.getText());
        values.put(COLUMN_CORRECT_ANSWER, question.getCorrectAnswer());
        values.put(COLUMN_OPT1, question.getOpt1());
        values.put(COLUMN_OPT2, question.getOpt2());

        db.insert(TABLE_QUESTIONS, null, values);
        db.close();
    }
    public List<Question> getaAQuestion(){

        List<Question> quesList = new ArrayList<>();

// Select AUL Query

        String selectQuery = "SELECT * FROM " + TABLE_QUESTIONS;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if (cursor.moveToFirst()){
            do{

                Question quest=new Question();
                quest.setId(cursor.getInt(0));
                quest.setText(cursor.getString(1));
                quest.setOpt1(cursor.getString(2));
                quest.setOpt2(cursor.getString(3));
                quesList.add(quest);

            }while (cursor.moveToNext());


        }return quesList;



    }
    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUESTIONS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }


}

