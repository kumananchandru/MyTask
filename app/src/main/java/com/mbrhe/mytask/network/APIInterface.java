package com.mbrhe.mytask.network;

import com.mbrhe.mytask.model.LoginModel;
import com.mbrhe.mytask.model.NewsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface
{

    @Headers({
            "Accept: application/json",
            "consumer-secret: 20891a1b4504ddc33d42501f9c8d2215fbe85008",
            "consumer-key: mobile_dev"
    })
    @GET("api/public/v1/news?local=en")
    Call<NewsModel> getNews();

    @Headers({
            "Accept: application/json",
            "consumer-secret: 20891a1b4504ddc33d42501f9c8d2215fbe85008",
            "consumer-key: mobile_dev"
    })
    @POST("api/iskan/v1/certificates/towhomitmayconcern")
    @FormUrlEncoded
    Call<LoginModel> login(@Field("eid") String eid,
                           @Field("name") String name,
                           @Field("idbarahno") String idbarahno,
                           @Field("emailaddress") String email,
                           @Field("unifiednumber") String unifiednumber,
                           @Field("mobileno") String mobileno);


}
