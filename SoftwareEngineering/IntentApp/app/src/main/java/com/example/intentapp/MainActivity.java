package com.example.intentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNextButton(View view){
//        Intent a= new Intent(this, SubActivity.class);
        Intent i= new Intent(this, SubActivity.class);
        startActivity(i);
    }
}