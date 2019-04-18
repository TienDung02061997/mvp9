package com.example.mvp9.Model.local;

import com.example.mvp9.Model.User;

public interface MethodDatabase {
    void insertUser(User user);
    boolean checkUser(String user);
}
