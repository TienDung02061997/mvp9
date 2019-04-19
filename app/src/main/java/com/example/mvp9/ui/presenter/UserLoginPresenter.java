package com.example.mvp9.ui.presenter;


import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.ui.contract.UserContractLogin;

public class UserLoginPresenter implements  UserContractLogin.Presenter {
    private  UserContractLogin.View mUserContractLogin;
    private UserRepostitory mRepostitory;

    public UserLoginPresenter(UserContractLogin.View userContractLogin, UserRepostitory repostitory) {
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
