package com.example.mvp9.tasks;

import com.example.mvp9.data.Repostitory;
import com.example.mvp9.data.User;

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
