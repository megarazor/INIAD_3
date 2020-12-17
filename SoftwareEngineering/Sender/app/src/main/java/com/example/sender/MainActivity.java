package com.example.sender;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendButtonOnClick(View view){
        EditText text= (EditText) findViewById(R.id.textInput);
        String content= text.getText().toString().trim();

        Intent sendIntent= new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, content);
        sendIntent.setType("text/plain");

        Intent shareIntent= Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
    }
}