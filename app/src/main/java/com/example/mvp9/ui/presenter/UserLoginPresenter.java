package com.example.mvp9.ui.presenter;


import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.ui.contract.UserLoginContract;

public class UserLoginPresenter implements  UserLoginContract.Presenter {
    private  UserLoginContract.View mUserContractLogin;
    private UserRepostitory mRepostitory;

    public UserLoginPresenter(UserLoginContract.View userContractLogin, UserRepostitory repostitory) {
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
