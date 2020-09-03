package com.example.info.login.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;


import com.example.info.login.response.LoginResponse;
import com.example.info.login.retrofit.ApiRequest;
import com.example.info.login.retrofit.LoginBody;
import com.example.info.login.retrofit.RetrofitRequest;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {
    private static final String TAG = LoginRepository.class.getSimpleName();
    private ApiRequest apiRequest;

    public LoginRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }

    public LiveData<String> getLoginData(String query, String key) {
        final MutableLiveData<String> data = new MutableLiveData<>();
        JSONObject paramObject = new JSONObject();

        try {
            paramObject.put("email", "sample@gmail.com");
            paramObject.put("pass", "4384984938943");
        } catch (JSONException e) {
            e.printStackTrace();
        }

       /* apiRequest.getLoginData(new LoginBody("username","1111111"))
                .enqueue(new Callback<String>() {


                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d(TAG, "onResponse response:: " + response);



                        if (response.body() != null) {
                            data.setValue(response.body());

                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        data.setValue(null);
                    }
                });*/
        return data;
    }
}
