package com.example.mvp9.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mvp9.data.User;


public class UserDatabase  extends SQLiteOpenHelper implements MethodDatabase {

    public UserDatabase(Context context) {
        super(context, DataDeclare.DB_NAME, null, DataDeclare.VESION);
    }
    @Override
    public void insertUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataDeclare.USER_NAME, user.getUsername());
        values.put(DataDeclare.PASSWORD, user.getPassword());
        long checkinsert = sqLiteDatabase.insert(DataDeclare.DB_TABLE, null, values);
        if (checkinsert > 0) {
            Log.d("insert", "complete  insertUser");
        } else {
            Log.d("insert", "false");
        }
    }

    @Override
    public boolean checkUser(String user) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(DataDeclare.DB_TABLE,null,
                DataDeclare.USER_NAME +" = ?",new String[]{user},
                null,null,null);
        cursor.moveToFirst();
        if(cursor.getCount()==0){
            return false;
        }
        return true;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE " + DataDeclare.DB_TABLE +
                " ( " + DataDeclare.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataDeclare.USER_NAME + " TEXT , " +
                DataDeclare.PASSWORD + " TEXT )";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
