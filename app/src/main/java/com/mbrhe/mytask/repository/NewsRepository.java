package com.mbrhe.mytask.repository;

import android.arch.lifecycle.MutableLiveData;
import com.mbrhe.mytask.model.NewsModel;
import com.mbrhe.mytask.network.APIInterface;
import com.mbrhe.mytask.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsRepository {

    private APIInterface apiInterface;


    public NewsRepository() {
    }

    public MutableLiveData<NewsModel> getNews() {
        final MutableLiveData<NewsModel> refferAndInvitePojoMutableLiveData = new MutableLiveData<>();
        apiInterface = ApiClient.getClientAuthentication().create(APIInterface.class);
        Call<NewsModel> call = apiInterface.getNews();
        call.enqueue(new Callback<NewsModel>() {
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                if (response.body() != null) {
                    refferAndInvitePojoMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {

            }
        });

        return refferAndInvitePojoMutableLiveData;
    }
}
