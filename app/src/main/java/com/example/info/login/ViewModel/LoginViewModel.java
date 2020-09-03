package com.example.info.login.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.info.login.Model.LoginUser;
import com.example.info.login.response.LoginResponse;
import com.example.info.login.retrofit.ApiRequest;
import com.example.info.login.retrofit.LoginBody;
import com.example.info.login.retrofit.RetrofitRequest;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> EmailAddress = new MutableLiveData<>();
    public MutableLiveData<String> Password = new MutableLiveData<>();

    private MutableLiveData<LoginUser> userMutableLiveData;

    public MutableLiveData<LoginUser> getUser() {

        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }
        return userMutableLiveData;

    }

    public void onClick(View view) {
        LoginUser loginUser = new LoginUser(EmailAddress.getValue(), Password.getValue());
        callLogin(loginUser);

    }

    public void callLogin(final LoginUser loginUser){
        JSONObject j1 = new JSONObject();
        try {
            j1.put("username",loginUser.getStrEmailAddress());
            j1.put("password",loginUser.getStrPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ApiRequest apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
        apiRequest.getLoginData(j1.toString())
                .enqueue(new Callback<LoginResponse>() {


                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        Log.d("TAG", "onResponse response:: " + response);
                        if (response.body() != null) {
                            loginUser.setResponse(response.toString());
                           userMutableLiveData.setValue(loginUser);
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("errrr",t.toString());
                        loginUser.setResponse("error");
                        userMutableLiveData.setValue(loginUser);
                    }
                });
    }


}
