package com.example.widgetstest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
    public void onRadioButtonClicked(View view){
        boolean checked= ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButton:
                if (checked)
                    Toast.makeText(MainActivity.this, getString(R.string.rabbit), Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton2:
                if (checked)
                    Toast.makeText(MainActivity.this, getString(R.string.panda), Toast.LENGTH_SHORT).show();
                break;
            case R.id.radioButton3:
                if (checked)
                    Toast.makeText(MainActivity.this, getString(R.string.cat), Toast.LENGTH_SHORT).show();
                break;
        }
    }

     */

    public void onApplyButtonClicked(View view){
        RadioButton rabbitBtn, pandaBtn, catBtn;
        ImageView img= (ImageView) findViewById(R.id.imageView);
        rabbitBtn= findViewById(R.id.radioButton);
        pandaBtn= findViewById(R.id.radioButton2);
        catBtn= findViewById(R.id.radioButton3);
        if (rabbitBtn.isChecked()){
            img.setImageResource(R.drawable.rabbit);
        }
        else if (pandaBtn.isChecked()){
            img.setImageResource(R.drawable.panda);
        }
        else if (catBtn.isChecked()){
            img.setImageResource(R.drawable.cat);
        }
        else{
            Toast.makeText(MainActivity.this, getString(R.string.selectOne), Toast.LENGTH_SHORT).show();
        }
    }
}