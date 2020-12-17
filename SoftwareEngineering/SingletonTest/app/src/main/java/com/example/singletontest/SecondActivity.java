package com.example.singletontest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private ModeManager modeManager= ModeManager.getInstance();
    private Switch aSwitch;
    private TextView textView;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView= findViewById(R.id.textView2);
        constraintLayout= findViewById(R.id.secondLayout);
        aSwitch= findViewById(R.id.switch2);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(SecondActivity.this, "on", Toast.LENGTH_SHORT).show();
                    modeManager.changeMode(DisplayMode.Easy);
                }
                else{
                    Toast.makeText(SecondActivity.this, "off", Toast.LENGTH_SHORT).show();
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
        aSwitch.setTextSize(modeManager.getFontSize());
        textView.setTextSize(modeManager.getFontSize());
        constraintLayout.setBackgroundColor(modeManager.getBgColor());
    }
}