package com.example.mvp9.data.local;


import com.example.mvp9.data.User;

public interface MethodDatabase {
    void insertUser(User user);
    boolean checkUser(String user);
}
