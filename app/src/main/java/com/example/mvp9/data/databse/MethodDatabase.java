package com.example.mvp9.data.databse;

import com.example.mvp9.data.User;

import java.util.List;

public interface MethodDatabase {
    void insertUser(User user);
    boolean checkUser(String user);
}
