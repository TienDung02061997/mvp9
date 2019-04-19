package com.example.mvp9.ui.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp9.R;
import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.data.local.UserDataLocal;
import com.example.mvp9.data.local.UserDatabase;
import com.example.mvp9.ui.contract.UserLoginContract;
import com.example.mvp9.ui.presenter.UserLoginPresenter;

public class LoginFragment extends Fragment implements View.OnClickListener, UserLoginContract.View {
    public View mView;
    protected EditText mEditTextUser, mEditTextPass;
    protected Button mButtonLogin, mButtonRegister;
    protected UserLoginContract.Presenter mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, container, false);
        FoundId();
        EventClick();
        mPresenter = new UserLoginPresenter(this, new UserRepostitory(new UserDataLocal(new UserDatabase(getActivity()))));
        return mView;
    }

    private void EventClick() {
        mButtonLogin.setOnClickListener(this);
        mButtonRegister.setOnClickListener(this);
    }

    private void FoundId() {
        mEditTextUser = mView.findViewById(R.id.edit_userlogin);
        mEditTextPass = mView.findViewById(R.id.edit_passlogin);
        mButtonLogin = mView.findViewById(R.id.button_Login);
        mButtonRegister = mView.findViewById(R.id.button_RegisterLogin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Login:
                checklogin();
                break;
            case R.id.button_RegisterLogin:
                replaceRegister();
                break;
            default:
                break;
        }
    }

    private void replaceRegister() {
        RegisterFragment registerFragment =new RegisterFragment();
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_main, registerFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void checklogin() {
        String user=mEditTextUser.getText().toString();
        mPresenter.checkUser(user);
    }

    @Override
    public void LoginSuccess() {
        Toast.makeText(getActivity(), getString(R.string.msg_login), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LoginFail() {
        Toast.makeText(getActivity(), getString(R.string.msg_loginfail), Toast.LENGTH_SHORT).show();
    }
}
