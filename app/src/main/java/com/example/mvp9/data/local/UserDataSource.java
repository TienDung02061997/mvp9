package com.example.mvp9.data.local;

import com.example.mvp9.data.local.RegisterUserAsyncTask.RegisterUserCallback;
import com.example.mvp9.model.User;

public interface UserDataSource {
    void insertUser(User user, RegisterUserCallback registerUserCallback);
    void isUserExisted(User user, LoginUserAsyncTask.LoginUserCallback loginUserCallback);
}
