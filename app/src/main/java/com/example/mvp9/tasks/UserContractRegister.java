package com.example.mvp9.tasks;


import com.example.mvp9.data.User;

public interface UserContractRegister {
    interface  view {
        void addUserComplete();
    }
    interface Presenter{
        void addUser(User user);
    }
}
