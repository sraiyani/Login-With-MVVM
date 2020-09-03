package com.example.info.login.retrofit;


import com.example.info.login.response.LoginResponse;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {
    @Headers({
            "Content-Type:application/json","IMSI:357175048449937","IMEI:510110406068589"
    })
    @POST("api/login")
    Call<LoginResponse> getLoginData(
            @Body String j1
            );
}
