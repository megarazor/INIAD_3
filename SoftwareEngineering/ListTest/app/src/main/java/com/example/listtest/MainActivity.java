package com.example.listtest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> data= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data.add("Apple"); data.add("Banana"); data.add("Kiwi");
        adapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView= findViewById(R.id.listView);
        listView.setAdapter(adapter);

        class ClickListener implements ListView.OnItemClickListener {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String content= (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, content, Toast.LENGTH_SHORT).show();
            }
        }
        listView.setOnItemClickListener(new ClickListener());
    }
}