package com.example.mvp9.ui.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.mvp9.R;
import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.data.local.UserDataLocal;
import com.example.mvp9.data.local.UserDatabase;
import com.example.mvp9.model.User;
import com.example.mvp9.ui.contract.UserContractRegister;
import com.example.mvp9.ui.presenter.UserRegisterPresenter;

public class RegisterFragment extends Fragment implements android.view.View.OnClickListener, UserContractRegister.view {
    private EditText mEditText_UserName, mEditText_Password;
    private Button mButton;
    public android.view.View view;
    public User mUser;
    public UserContractRegister.Presenter mPresenter;

    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register, container, false);
        FindByID();
        EventClick();
        mPresenter=new UserRegisterPresenter(this, new UserRepostitory(new UserDataLocal(new UserDatabase(getActivity()))));
        return view;
    }

    private void EventClick() {
        mButton.setOnClickListener(this);
    }

    private void FindByID() {
        mEditText_UserName = view.findViewById(R.id.edit_userlogin);
        mEditText_Password = view.findViewById(R.id.edit_password);
        mButton = view.findViewById(R.id.button_add_user);

    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.button_add_user:
                addUser();
                break;
            default:
                break;
        }
    }
    public void replace() {
        LoginFragment loginFragment = new LoginFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frag_main, loginFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void  addUser(){
        String username = mEditText_UserName.getText().toString();
        String password = mEditText_Password.getText().toString();
        mUser =new User();
        mUser.setUsername(username);
        mUser.setPassword(password);
        mPresenter.addUser(mUser);
    }

    @Override
    public void addUserComplete() {
        replace();
        Toast.makeText(getContext(), "thanh cong", Toast.LENGTH_SHORT).show();
    }

}