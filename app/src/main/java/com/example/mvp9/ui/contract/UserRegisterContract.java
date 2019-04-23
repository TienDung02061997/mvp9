package com.example.mvp9.ui.contract;

import com.example.mvp9.model.User;

public interface UserRegisterContract {
    interface View {
        void showSuccessfullyRegistration();
        void showFailRegistration();
    }

    interface Presenter {
        void registerUser(User user);
    }
}
