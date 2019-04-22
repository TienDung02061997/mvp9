package com.example.mvp9.data.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mvp9.model.User;


public class UserDatabase extends SQLiteOpenHelper implements UserDataSource {

    public UserDatabase(Context context ) {
        super(context, DataConstants.DB_NAME, null, DataConstants.VESION);
    }

    @Override
    public void insertUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DataConstants.USER_NAME, user.getUsername());
        values.put(DataConstants.PASSWORD, user.getPassword());
        sqLiteDatabase.insert(DataConstants.DB_TABLE, null, values);
    }

    @Override
    public boolean checkUser(String user) {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query(DataConstants.DB_TABLE,null,
                DataConstants.USER_NAME +" = ?",new String[]{user},
                null,null,null);
        cursor.moveToFirst();
        if(cursor.getCount()==0){
            return false;
        }
        return true;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL = "CREATE TABLE " + DataConstants.DB_TABLE +
                " ( " + DataConstants.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DataConstants.USER_NAME + " TEXT , " +
                DataConstants.PASSWORD + " TEXT )";
        db.execSQL(SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
