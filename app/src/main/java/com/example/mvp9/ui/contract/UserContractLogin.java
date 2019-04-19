package com.example.mvp9.ui.contract;

public interface UserContractLogin {
    interface  Presenter{
        void checkUser(String user);
    }
    interface  View{
        void LoginSuccess();
        void LoginFail();
    }
}
