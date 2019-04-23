package com.example.mvp9.ui.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp9.R;
import com.example.mvp9.data.UserRepostitory;
import com.example.mvp9.data.local.UserDatabase;
import com.example.mvp9.data.local.UserLocalDataSource;
import com.example.mvp9.model.User;
import com.example.mvp9.ui.contract.UserLoginContract;
import com.example.mvp9.ui.presenter.UserLoginPresenter;

public class LoginFragment extends Fragment implements View.OnClickListener, UserLoginContract.View {
    private static LoginFragment sInstance;
    private EditText mEditTextUser;
    protected Button mButtonLogin, mButtonRegister;
    protected UserLoginContract.Presenter mPresenter;
    private OpenRegisterFragmentCallback mOpenRegisterFragmentCallback;

    public static synchronized LoginFragment getInstance() {
        if (sInstance == null) {
            sInstance = new LoginFragment();
        }
        return sInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_login, container, false);
        mPresenter = new UserLoginPresenter(this, UserRepostitory.getInstance(
                new UserLocalDataSource(new UserDatabase(getContext()))));
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        initView();
        initClickListeners();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() instanceof OpenRegisterFragmentCallback) {
            mOpenRegisterFragmentCallback = (OpenRegisterFragmentCallback) getActivity();
        }
    }

    private void initView() {
        mEditTextUser = getView().findViewById(R.id.edit_userlogin);
        mButtonLogin = getView().findViewById(R.id.button_Login);
        mButtonRegister = getView().findViewById(R.id.button_RegisterLogin);
    }

    private void initClickListeners() {
        mButtonLogin.setOnClickListener(this);
        mButtonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_Login:
                excuteLogin();
                break;
            case R.id.button_RegisterLogin:
                mOpenRegisterFragmentCallback.openRegisterFragment();
                break;
            default:
                break;
        }
    }

    private void excuteLogin() {
        String user = mEditTextUser.getText().toString();
        User user1 = new User();
        user1.setUsername(user);
        mPresenter.excuteLogin(user1);
    }

    @Override
    public void showLoginSuccessfully() {
        Toast.makeText(getActivity(), getString(R.string.msg_login), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoginFailed() {
        Toast.makeText(getActivity(), getString(R.string.msg_loginfail), Toast.LENGTH_SHORT).show();
    }

    interface OpenRegisterFragmentCallback {
        void openRegisterFragment();
    }
}
