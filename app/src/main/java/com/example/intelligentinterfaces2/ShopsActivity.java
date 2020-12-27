package com.example.intelligentinterfaces2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ShopsActivity extends AppCompatActivity {
    ListView shopList;
    ArrayList<RowDataModelShops> dataModelShops;
    private static CustomAdapterShops customAdapterShops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);
        shopList = findViewById(R.id.recommended_shops_list);
        dataModelShops = new ArrayList<RowDataModelShops>();
        for( int i = 0; i < 5; i ++){
            dataModelShops.add(new RowDataModelShops("Shop" + i));
        }

        customAdapterShops = new CustomAdapterShops(dataModelShops,getApplicationContext());
        shopList.setAdapter(customAdapterShops);

        shopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RowDataModelShops clickedRow = dataModelShops.get(position);
                Toast.makeText(ShopsActivity.this, clickedRow.getItem(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

