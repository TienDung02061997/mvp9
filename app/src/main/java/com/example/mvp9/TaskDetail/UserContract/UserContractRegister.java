package com.example.mvp9.TaskDetail.UserContract;


import com.example.mvp9.Model.User;

public interface UserContractRegister {
    interface  view {
        void addUserComplete();
    }
    interface Presenter{
        void addUser(User user);
    }
}
