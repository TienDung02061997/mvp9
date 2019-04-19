package com.example.mvp9.data;

import com.example.mvp9.data.local.UserDataLocal;
import com.example.mvp9.data.local.MethodDatabase;
import com.example.mvp9.model.User;

public class UserRepostitory implements MethodDatabase {
    private UserDataLocal mUserDataLocal;

    public UserRepostitory(UserDataLocal userDataLocal) {
        mUserDataLocal = userDataLocal;
    }


    @Override
    public void insertUser(User user) {
        mUserDataLocal.insertUser(user);
    }

    @Override
    public boolean checkUser(String user) {
        if(mUserDataLocal.checkUser(user)){
            return true;
        }else {
            return false;
        }
    }


}
