package com.example.receiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i= getIntent();
        String action= i.getAction();
        String type= i.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                String sharedText= i.getStringExtra(Intent.EXTRA_TEXT);
                if (sharedText != null) {
                    ImageView img= (ImageView) findViewById(R.id.imageView);
                    if (sharedText.equals("Pig") || sharedText.equals("pig")){
                        img.setImageResource(R.drawable.pig);
                    }
                    else if (sharedText.equals("Dog") || sharedText.equals("dog")){
                        img.setImageResource(R.drawable.dog);
                    }
                    else if (sharedText.equals("bear") || sharedText.equals("Bear")){
                        img.setImageResource(R.drawable.bear);
                    }
                    else {
                        img.setImageResource(R.drawable.ic_launcher_foreground);
                    }
                }
            }
        }
    }
}