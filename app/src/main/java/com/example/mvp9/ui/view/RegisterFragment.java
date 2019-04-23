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
import com.example.mvp9.ui.contract.UserRegisterContract;
import com.example.mvp9.ui.presenter.UserRegisterPresenter;

public class RegisterFragment extends Fragment implements android.view.View.OnClickListener,
        UserRegisterContract.View {
    private static RegisterFragment sInstance;
    private EditText mEditText_UserName;
    private EditText mEditText_Password;
    private Button mButtonRegister;
    public User mUser;
    public UserRegisterContract.Presenter mPresenter;
    private OpenLoginFragmentCallback mOpenLoginFragmentCallback;

    public static synchronized RegisterFragment getInstance() {
        if (sInstance == null) {
            sInstance = new RegisterFragment();
        }
        return sInstance;
    }


    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container,
                                          Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_register, container, false);
        mPresenter = new UserRegisterPresenter(this, UserRepostitory.getInstance(
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
        if (getActivity() instanceof OpenLoginFragmentCallback) {
            mOpenLoginFragmentCallback = (OpenLoginFragmentCallback) getActivity();
        }
    }

    private void initClickListeners() {
        mButtonRegister.setOnClickListener(this);
    }

    private void initView() {
        mEditText_UserName = getView().findViewById(R.id.edit_userlogin);
        mEditText_Password = getView().findViewById(R.id.edit_password);
        mButtonRegister = getView().findViewById(R.id.button_add_user);
    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId()) {
            case R.id.button_add_user:
                registerUser();
                mOpenLoginFragmentCallback.openLoginFragment();
                break;
            default:
                break;
        }
    }

    public void registerUser() {
        String username = mEditText_UserName.getText().toString();
        String password = mEditText_Password.getText().toString();
        mUser = new User();
        mUser.setUsername(username);
        mUser.setPassword(password);
        mPresenter.registerUser(mUser);
    }

    @Override
    public void showSuccessfullyRegistration() {
        mOpenLoginFragmentCallback.openLoginFragment();
        Toast.makeText(getContext(), getString(R.string.msg_success), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailRegistration() {
        Toast.makeText(getContext(), getString(R.string.msg_faill), Toast.LENGTH_SHORT).show();
    }

    interface OpenLoginFragmentCallback {
        void openLoginFragment();
    }
}