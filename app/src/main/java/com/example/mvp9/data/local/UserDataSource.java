package com.example.mvp9.data.local;


import com.example.mvp9.model.User;

public interface UserDataSource {
    void insertUser(User user);
    boolean checkUser(String user);
}
