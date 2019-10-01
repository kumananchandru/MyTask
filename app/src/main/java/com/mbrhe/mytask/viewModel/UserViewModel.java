package com.mbrhe.mytask.viewModel;

import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.mbrhe.mytask.model.LoginModel;
import com.mbrhe.mytask.model.UserModel;
import com.mbrhe.mytask.network.APIInterface;
import com.mbrhe.mytask.network.ApiClient;
import com.mbrhe.mytask.view.news.NewsListActivity;

import retrofit2.Call;
import retrofit2.Callback;

public class UserViewModel extends ViewModel {

    public MutableLiveData<String> eid = new MutableLiveData<>();
    public MutableLiveData<String> name = new MutableLiveData<>();
    public MutableLiveData<String> idbarahno = new MutableLiveData<>();
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> unifiednumber = new MutableLiveData<>();
    public MutableLiveData<String> mobileno = new MutableLiveData<>();
    public MutableLiveData<String> welcome = new MutableLiveData<>();

    private MutableLiveData<LoginModel> data;
    private APIInterface apiInterface;
    private MutableLiveData<Integer> busy;

    private UserModel user;
    private Context context;

    public UserViewModel(Context context, UserModel user) {
        this.user = user;
        this.context = context;
        this.welcome.setValue(user.getWelcomeMessage());
    }


    public MutableLiveData<Integer> getBusy() {

        if (busy == null) {
            busy = new MutableLiveData<>();
            busy.setValue(View.GONE);
        }

        return busy;
    }

    public void onLoginClick() {
        user.setEid(eid.getValue());
        user.setName(name.getValue());
        user.setIdbarahno(idbarahno.getValue());
        user.setEmail(email.getValue());
        user.setUnifiednumber(unifiednumber.getValue());
        user.setMobileno(mobileno.getValue());

        if (!user.isValidEid()) {
            Toast.makeText(context, "Invalid Eid", Toast.LENGTH_SHORT).show();
        } else if (!user.isValidName()) {
            Toast.makeText(context, "Invalid Name", Toast.LENGTH_SHORT).show();
        } else if (!user.isValidIdbarahno()) {
            Toast.makeText(context, "Idbarahno Should be Minimum 7 Characters", Toast.LENGTH_SHORT).show();
        } else if (!user.isValidEmail()) {
            Toast.makeText(context, "Invalid Email", Toast.LENGTH_SHORT).show();
        } else if (!user.isValidUnifiedNo()) {
            Toast.makeText(context, "Invalid Unified No", Toast.LENGTH_SHORT).show();
        } else if (!user.isValidMobile()) {
            Toast.makeText(context, "Invalid Mobile No", Toast.LENGTH_SHORT).show();
        } else {

            getBusy().setValue(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    apiInterface = ApiClient.getClientAuthentication().create(APIInterface.class);
                    Call<LoginModel> call = apiInterface.login(user.getEid(), user.getName(), user.getIdbarahno(), user.getEmail(), user.getUnifiednumber(), user.getMobileno());
                    call.enqueue(new Callback<LoginModel>() {
                        @Override
                        public void onResponse(Call<LoginModel> call, retrofit2.Response<LoginModel> response) {
                            if (response.isSuccessful()) {
                                Intent intent = new Intent(context, NewsListActivity.class);
                                intent.putExtra("USER_OBJ", user);
                                context.startActivity(intent);
                                ((Activity) context).finish();
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginModel> call, Throwable t) {
                            t.printStackTrace();
                            Toast.makeText(context, "Something went wrong. Please try again", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }, 500);


        }
    }
}