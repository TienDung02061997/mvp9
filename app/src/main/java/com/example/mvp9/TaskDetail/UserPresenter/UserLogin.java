package com.example.mvp9.TaskDetail.UserPresenter;

import com.example.mvp9.Model.Repostitory;
import com.example.mvp9.TaskDetail.UserContract.UserContractLogin;

public class UserLogin implements  UserContractLogin.Presenter {
    private  UserContractLogin.View mUserContractLogin;
    private Repostitory mRepostitory;

    public UserLogin(UserContractLogin.View userContractLogin, Repostitory repostitory) {
        mUserContractLogin = userContractLogin;
        mRepostitory = repostitory;
    }

    @Override
    public void checkUser(String user) {
      if(mRepostitory.checkUser(user)){
          mUserContractLogin.LoginSuccess();
      } else {
        mUserContractLogin.LoginFail();
      }
    }
}
