package com.example.mvp9.ui.presenter;


import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.model.User;
import com.example.mvp9.ui.contract.UserContractRegister;

public class UserRegisterPresenter implements  UserContractRegister.Presenter {
    private  UserContractRegister.view mView;
    private UserRepostitory mRepostitory;

    public UserRegisterPresenter(UserContractRegister.view view, UserRepostitory repostitory) {
        mView = view;
        mRepostitory = repostitory;
    }

    @Override
    public void addUser(User user) {
     mRepostitory.insertUser(user);
     mView.addUserComplete();
    }
}
