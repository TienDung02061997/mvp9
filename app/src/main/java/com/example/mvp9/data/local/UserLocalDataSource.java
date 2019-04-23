package com.example.mvp9.data.local;

import com.example.mvp9.model.User;

public class UserLocalDataSource implements UserDataSource {
    private UserDatabase mUserDatabase;

    public UserLocalDataSource(UserDatabase userDatabase) {
        mUserDatabase = userDatabase;
    }

    @Override
    public void insertUser(User user, RegisterUserAsyncTask.RegisterUserCallback registerUserCallback) {
        new RegisterUserAsyncTask(mUserDatabase, registerUserCallback).execute(user);
    }

    @Override
    public void isUserExisted(User user, LoginUserAsyncTask.LoginUserCallback loginUserCallback) {
        new LoginUserAsyncTask(mUserDatabase, loginUserCallback).execute(user);
    }
}
