package com.example.intentandlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RadioButton;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent i= getIntent();
        String animal= i.getStringExtra("animal");
        ImageView img= (ImageView) findViewById(R.id.imageView);
        if (animal.equals("Pig")){
            img.setImageResource(R.drawable.pig);
        }
        else if (animal.equals("Dog")){
            img.setImageResource(R.drawable.dog);
        }
        else if (animal.equals("Bear")){
            img.setImageResource(R.drawable.bear);
        }

    }
}