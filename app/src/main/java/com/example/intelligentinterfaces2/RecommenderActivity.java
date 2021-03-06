package com.example.intelligentinterfaces2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
        getSupportActionBar().setTitle("Recommended Items");
        itemList = findViewById(R.id.recommended_list);
        dataModels = new ArrayList<RowDataModel>();
        dataModels.add(new RowDataModel("Cereal", R.drawable.cereal));
        dataModels.add(new RowDataModel("Apples", R.drawable.apple));
        dataModels.add(new RowDataModel("Burger", R.drawable.burger));
        dataModels.add(new RowDataModel("Churros", R.drawable.churros));
        dataModels.add(new RowDataModel("Milk", R.drawable.milk));

        customAdapter = new CustomAdapter(dataModels,getApplicationContext());
        itemList.setAdapter(customAdapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RowDataModel clickedRow = dataModels.get(position);
                VisitShops();
            }
        });
    }

    public void VisitShops(){
        Intent intent = new Intent(this, ShopsActivity.class);
        startActivity(intent);
    }
}