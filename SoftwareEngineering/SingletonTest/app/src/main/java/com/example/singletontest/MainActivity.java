package com.example.singletontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ModeManager modeManager= ModeManager.getInstance();
    private Switch aSwitch;
    private TextView textView;
    private Button button;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.textView);
        button= findViewById(R.id.button);
        constraintLayout= findViewById(R.id.mainLayout);
        aSwitch= findViewById(R.id.switch1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(MainActivity.this, "on", Toast.LENGTH_SHORT).show();
                    modeManager.changeMode(DisplayMode.Easy);
                }
                else{
                    Toast.makeText(MainActivity.this, "off", Toast.LENGTH_SHORT).show();
                    modeManager.changeMode(DisplayMode.Default);
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        aSwitch.setTextColor(modeManager.getFontColor());
        textView.setTextColor(modeManager.getFontColor());
        button.setTextColor(modeManager.getFontColor());
        aSwitch.setTextSize(modeManager.getFontSize());
        textView.setTextSize(modeManager.getFontSize());
        button.setTextSize(modeManager.getFontSize());
        constraintLayout.setBackgroundColor(modeManager.getBgColor());
    }

    public void onBtnClick(View view){
        Intent i= new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}