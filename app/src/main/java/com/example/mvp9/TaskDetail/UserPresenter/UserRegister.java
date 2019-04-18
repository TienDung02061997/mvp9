package com.example.mvp9.TaskDetail.UserPresenter;

import com.example.mvp9.Model.Repostitory;
import com.example.mvp9.Model.User;
import com.example.mvp9.TaskDetail.UserContract.UserContractRegister;

public class UserRegister implements  UserContractRegister.Presenter {
    private  UserContractRegister.view mView;
    private Repostitory mRepostitory;

    public UserRegister(UserContractRegister.view view, Repostitory repostitory) {
        mView = view;
        mRepostitory = repostitory;
    }

    @Override
    public void addUser(User user) {
     mRepostitory.insertUser(user);
     mView.addUserComplete();
    }
}
