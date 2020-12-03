package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop(){
        int num= 13;
        super.onStop();
    }

    public void onClick(View view){
        EditText editText= (EditText) findViewById(R.id.editTextTextPersonName2);
        String editTextContent= editText.getText().toString();
        TextView textView= (TextView) findViewById(R.id.textView);
        textView.setText(editTextContent);
    }
}