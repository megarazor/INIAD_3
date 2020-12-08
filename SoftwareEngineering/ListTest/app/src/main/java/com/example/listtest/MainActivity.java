package com.example.listtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> data= new ArrayList<>();
        data.add("Pig"); data.add("Bear"); data.add("Dog");
        data.add("Cat"); data.add("Elephant"); data.add("Lion");
        data.add("Hippo"); data.add("Tiger"); data.add("Rabbit");
        data.add("Panda"); data.add("Monkey"); data.add("Penguin");
        data.add("Sheep"); data.add("Koala"); data.add("Squirrel");

        ArrayAdapter<String> adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        ListView listView= findViewById(R.id.listView);
        listView.setAdapter(adapter);

        class ClickListener implements AdapterView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String content= (String) parent.getItemAtPosition(position);
//                Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
//                Log.i("MainActivity", "position" + position);
                AlertDialog.Builder builder= new AlertDialog.Builder(this);
                
            }
        }
        listView.setOnItemClickListener(new ClickListener());
    }
}