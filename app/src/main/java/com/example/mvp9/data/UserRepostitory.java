package com.example.mvp9.data;

import com.example.mvp9.data.local.UserDataSource;
import com.example.mvp9.model.User;

public class UserRepostitory implements UserDataSource {
    private UserDataSource mUserDataLocal;
    private static  UserRepostitory instance;
    private UserRepostitory(){}
    public static UserRepostitory getInstance(UserDataSource userDataSource)
    {
        if(instance==null){
            synchronized (UserRepostitory.class){
                if(instance==null){
                    instance=new UserRepostitory(userDataSource);
                }
            }
        }
        return instance;
    }

    private UserRepostitory(UserDataSource userDataSource) {
        mUserDataLocal =  userDataSource;
    }

    @Override
    public void insertUser(User user) {
        mUserDataLocal.insertUser(user);
    }

    @Override
    public boolean checkUser(String user) {
        if(mUserDataLocal.checkUser(user)){
            return true;
        }else {
            return false;
        }
    }


}
