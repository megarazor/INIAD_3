package com.example.observertest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private LightManager lightManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lightManager= new LightManager(this);
        lightManager.addObserver(new Item("Observer1", (Button) findViewById(R.id.button1)));
        lightManager.addObserver(new Item("Observer2", (Button) findViewById(R.id.button2)));
        lightManager.addObserver(new Item("Observer3", (Button) findViewById(R.id.button3)));
    }

    @Override
    protected void onResume(){
        super.onResume();
        lightManager.execute();
    }

    @Override
    protected void onPause(){
        super.onPause();
        lightManager.stopExecute();
    }
}