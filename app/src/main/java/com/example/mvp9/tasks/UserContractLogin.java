package com.example.mvp9.tasks;

import com.example.mvp9.data.User;

public interface UserContractLogin {
    interface  Presenter{
        void checkUser(String user);
    }
    interface  View{
        void LoginSuccess();
        void LoginFail();
    }
}
