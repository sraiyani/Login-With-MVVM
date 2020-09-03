package com.example.info.login.retrofit;

public class LoginBody {
    private final String username;
    private final String password;

    public LoginBody(String username, String password) {
        this.username = username;
        this.password = password;
    }
}