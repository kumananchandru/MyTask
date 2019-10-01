package com.mbrhe.mytask.view.login;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mbrhe.mytask.R;
import com.mbrhe.mytask.databinding.ActivityLoginBinding;
import com.mbrhe.mytask.model.UserModel;
import com.mbrhe.mytask.viewModel.UserViewModel;
import com.mbrhe.mytask.viewModel.UserViewModelFactory;

public class LoginActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /**
         * Create instance for data binding auto generated class file
         */
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        /**
         * Create instance for ViewModel class
         */

        UserViewModel userViewModel = ViewModelProviders.of(this, new UserViewModelFactory(this, new UserModel())).get(UserViewModel.class);

        /**
         * Set ViewModel instance to binding class
         */
        binding.setUserViewModel(userViewModel);
    }
}