package com.example.mvp9.Model;

import com.example.mvp9.Model.local.DataLocal;
import com.example.mvp9.Model.local.MethodDatabase;

public class Repostitory  implements MethodDatabase {
    private DataLocal mDataLocal;

    public Repostitory(DataLocal dataLocal) {
        mDataLocal = dataLocal;
    }

    @Override
    public void insertUser(User user) {
        mDataLocal.insertUser(user);
    }

    @Override
    public boolean checkUser(String user) {
        if(mDataLocal.checkUser(user)){
            return true;
        }else {
            return false;
        }
    }


}
