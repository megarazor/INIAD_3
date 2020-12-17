package com.example.intentandlistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> data= new ArrayList<>();
        data.add("Pig"); data.add("Bear"); data.add("Dog");

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ListView listView= findViewById(R.id.listView);
        listView.setAdapter(adapter);

        class ClickListener implements AdapterView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String animal= (String) parent.getItemAtPosition(position);
                Intent i= new Intent(MainActivity.this, ImageActivity.class);
                i.putExtra("animal", animal);
                startActivity(i);
            }
        }
        listView.setOnItemClickListener(new ClickListener());
    }
}