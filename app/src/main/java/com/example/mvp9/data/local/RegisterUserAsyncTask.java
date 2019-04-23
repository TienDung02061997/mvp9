package com.example.mvp9.data.local;

import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;

import com.example.mvp9.model.User;

public class RegisterUserAsyncTask extends AsyncTask<User, Void, Boolean> {
    private boolean result;
    private Exception exception;
    private UserDatabase mDatabase;
    private RegisterUserCallback mRegisterUserCallback;

    public RegisterUserAsyncTask(UserDatabase database, RegisterUserCallback registerUserCallback) {
        mDatabase = database;
        mRegisterUserCallback = registerUserCallback;
    }

    @Override
    protected Boolean doInBackground(User... params) {
        if (params.length == 0) {
            return null;
        }
        User user = params[0];
        try {
            result = mDatabase.insertUser(user);
        } catch (SQLiteException e) {
            exception = e;
        }

        return result;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (result) {
            mRegisterUserCallback.onRegisterSuccess();
        } else {
            mRegisterUserCallback.onRegisterFail();
        }
    }

    public interface RegisterUserCallback {
        void onRegisterSuccess();

        void onRegisterFail();
    }
}
