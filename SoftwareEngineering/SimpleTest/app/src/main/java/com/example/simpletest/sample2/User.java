package com.example.simpletest.sample2;

public class User {
    private String username;
    private String password;

    User(String username, String password){
        this.username= username;
        this.password= password;
    }

    protected String getUsername(){
        return username;
    }

    protected String getPassword(){
        return password;
    }
}
