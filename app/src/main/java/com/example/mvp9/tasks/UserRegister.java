package com.example.mvp9.tasks;

import com.example.mvp9.data.Repostitory;
import com.example.mvp9.data.User;

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
