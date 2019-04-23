package com.example.mvp9.data;

import com.example.mvp9.data.local.LoginUserAsyncTask;
import com.example.mvp9.data.local.RegisterUserAsyncTask;
import com.example.mvp9.data.local.UserDataSource;
import com.example.mvp9.model.User;

public class UserRepostitory implements UserDataSource {
    private UserDataSource mUserDataLocal;
    private static UserRepostitory sInstance;

    public static UserRepostitory getInstance(UserDataSource userDataSource) {
        if (sInstance == null) {
            synchronized (UserRepostitory.class) {
                if (sInstance == null) {
                    sInstance = new UserRepostitory(userDataSource);
                }
            }
        }
        return sInstance;
    }

    private UserRepostitory(UserDataSource userDataLocal) {
        mUserDataLocal = userDataLocal;
    }

    @Override
    public void insertUser(User user, RegisterUserAsyncTask.RegisterUserCallback registerUserCallback) {
        mUserDataLocal.insertUser(user, registerUserCallback);
    }

    @Override
    public void isUserExisted(User user, LoginUserAsyncTask.LoginUserCallback loginUserCallback) {
        mUserDataLocal.isUserExisted(user, loginUserCallback);
    }

}
