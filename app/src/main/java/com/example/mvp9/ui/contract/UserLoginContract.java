package com.example.mvp9.ui.contract;

import com.example.mvp9.model.User;

public interface UserLoginContract {
    interface Presenter {
        void excuteLogin(User username);
    }

    interface View {
        void showLoginSuccessfully();
        void showLoginFailed();
    }
}
