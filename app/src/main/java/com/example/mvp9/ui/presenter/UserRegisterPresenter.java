package com.example.mvp9.ui.presenter;

import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.data.local.RegisterUserAsyncTask;
import com.example.mvp9.model.User;
import com.example.mvp9.ui.contract.UserRegisterContract;

public class UserRegisterPresenter implements UserRegisterContract.Presenter {
    private UserRegisterContract.View mView;
    private UserRepostitory mRepostitory;

    public UserRegisterPresenter(UserRegisterContract.View view, UserRepostitory repostitory) {
        mView = view;
        mRepostitory = repostitory;
    }

    @Override
    public void registerUser(User user) {
        mRepostitory.insertUser(user, new RegisterUserAsyncTask.RegisterUserCallback() {
            @Override
            public void onRegisterSuccess() {
                mView.showSuccessfullyRegistration();
            }

            @Override
            public void onRegisterFail() {
                mView.showFailRegistration();
            }
        });
    }
}
