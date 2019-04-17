package com.example.mvp9.data.databse;

import android.util.Log;

import com.example.mvp9.data.User;

public class DataLocal implements MethodDatabase {
    UserDatabase mUserDatabase;

    public DataLocal(UserDatabase userDatabase) {
        mUserDatabase = userDatabase;
    }

    @Override
    public void insertUser(User user) {
        mUserDatabase.insertUser(user);

    }

    @Override
    public boolean checkUser(String user) {
        if(mUserDatabase.checkUser(user)){
            return true;
        }else {
            return false;
        }
    }

}
