package com.example.intelligentinterfaces2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.inputmethodservice.Keyboard;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecommenderActivity extends AppCompatActivity {
    ListView itemList;
    ArrayList<RowDataModel> dataModels;
    private static CustomAdapter customAdapter;
    //arrays for images and text beneath the item could also be added but for now they are going to be left as defaults.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommender);
        itemList = findViewById(R.id.recommended_list);
        dataModels = new ArrayList<RowDataModel>();
        for( int i = 0; i < 5; i ++){
            dataModels.add(new RowDataModel("Item" + i));
        }

        customAdapter = new CustomAdapter(dataModels,getApplicationContext());
        itemList.setAdapter(customAdapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RowDataModel clickedRow = dataModels.get(position);
                Toast.makeText(RecommenderActivity.this, clickedRow.getItem(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}