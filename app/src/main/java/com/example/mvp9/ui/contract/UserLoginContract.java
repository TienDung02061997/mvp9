package com.example.mvp9.ui.contract;

public interface UserLoginContract {
    interface  Presenter{
        void checkUser(String user);
    }
    interface  View{
        void LoginSuccess();
        void LoginFail();
    }
}
