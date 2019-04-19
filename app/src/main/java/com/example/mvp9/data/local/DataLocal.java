package com.example.mvp9.data.local;


import com.example.mvp9.data.User;

public class DataLocal implements MethodDatabase {
  private UserDatabase mUserDatabase;

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
