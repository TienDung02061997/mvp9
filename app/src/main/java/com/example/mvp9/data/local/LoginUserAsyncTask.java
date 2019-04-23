package com.example.mvp9.data.local;

import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;

import com.example.mvp9.model.User;

public class LoginUserAsyncTask extends AsyncTask<User, Void, Boolean> {
    private boolean result;
    private Exception exception;
    private UserDatabase mDatabase;
    private LoginUserCallback mLoginUserCallback;

    public LoginUserAsyncTask(UserDatabase database, LoginUserCallback loginUserCallback) {
        mDatabase = database;
        mLoginUserCallback = loginUserCallback;
    }

    @Override
    protected Boolean doInBackground(User... users) {
        if (users.length == 0) {
            return null;
        }
        User users1 = users[0];
        try {
            result = mDatabase.isUserExisted(users1);
        } catch (SQLiteException e) {
            exception = e;
        }
        return result;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (result) {
            mLoginUserCallback.onLoginSuccess();
        } else {
            mLoginUserCallback.onLoginFaill();
        }
    }

    public interface LoginUserCallback {
        void onLoginSuccess();

        void onLoginFaill();
    }
}
