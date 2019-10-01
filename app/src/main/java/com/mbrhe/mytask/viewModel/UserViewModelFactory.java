package com.mbrhe.mytask.viewModel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.mbrhe.mytask.model.UserModel;

public class UserViewModelFactory extends ViewModelProvider.NewInstanceFactory
{
    private UserModel user;
    private Context context;

    public UserViewModelFactory(Context context, UserModel user)
    {
        this.context = context;
        this.user = user;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass)
    {
        return (T) new UserViewModel(context, user);
    }
}