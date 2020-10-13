package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView citiesLv;
    private ArrayAdapter adapter;
    private String cities[] = {"Madrid", "Santiago", "Sydney", "Miami", "Tokyo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        registerViewClickListener();
    }

    private void registerViewClickListener() {
        citiesLv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                intent.putExtra("city", (String) parent.getItemAtPosition(position));
                startActivity(intent);
            }
        });
    }

    private void initialize() {
        citiesLv = findViewById(R.id.citiesLv);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cities);
        citiesLv.setAdapter(adapter);
    }
}