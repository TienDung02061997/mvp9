package com.example.mvp9.TaskDetail.UserContract;

public interface UserContractLogin {
    interface  Presenter{
        void checkUser(String user);
    }
    interface  View{
        void LoginSuccess();
        void LoginFail();
    }
}
