package com.example.mvp9.ui.presenter;


import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.model.User;
import com.example.mvp9.ui.contract.UserRegisterContract;

public class UserRegisterPresenter implements  UserRegisterContract.Presenter {
    private  UserRegisterContract.view mView;
    private UserRepostitory mRepostitory;

    public UserRegisterPresenter(UserRegisterContract.view view, UserRepostitory repostitory) {
        mView = view;
        mRepostitory = repostitory;
    }

    @Override
    public void addUser(User user) {
     mRepostitory.insertUser(user);
     mView.addUserComplete();
    }
}
