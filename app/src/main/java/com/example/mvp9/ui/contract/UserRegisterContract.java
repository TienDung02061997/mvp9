package com.example.mvp9.ui.contract;


import com.example.mvp9.model.User;

public interface UserRegisterContract {
    interface  view {
        void addUserComplete();
    }
    interface Presenter{
        void addUser(User user);
    }
}
