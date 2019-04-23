package com.example.mvp9.ui.presenter;

import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.data.local.LoginUserAsyncTask;
import com.example.mvp9.model.User;
import com.example.mvp9.ui.contract.UserLoginContract;

public class UserLoginPresenter implements UserLoginContract.Presenter {
    private UserLoginContract.View mView;
    private UserRepostitory mRepostitory;

    public UserLoginPresenter(UserLoginContract.View view, UserRepostitory repostitory) {
        mView = view;
        mRepostitory = repostitory;
    }

    @Override
    public void excuteLogin(User username) {
        mRepostitory.isUserExisted(username, new LoginUserAsyncTask.LoginUserCallback() {
            @Override
            public void onLoginSuccess() {
                mView.showLoginSuccessfully();
            }

            @Override
            public void onLoginFaill() {
                mView.showLoginFailed();
            }
        });
    }
}
