package com.example.intelligentinterfaces2;

import android.content.Intent;
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
        getSupportActionBar().setTitle("Shops");
        shopList = findViewById(R.id.recommended_shops_list);

        dataModelShops = new ArrayList<RowDataModelShops>();

        dataModelShops.add(new RowDataModelShops("Lidl Santa Venera", R.drawable.lidl));
        dataModelShops.add(new RowDataModelShops("Valyou Naxxar", R.drawable.valyou));
        dataModelShops.add(new RowDataModelShops("Park Towers Santa Venera", R.drawable.parktowers));
        dataModelShops.add(new RowDataModelShops("Scotts Sliema", R.drawable.scotts));
        dataModelShops.add(new RowDataModelShops("PAVI Qormi", R.drawable.pavi));
        dataModelShops.add(new RowDataModelShops("PAMA Mosta", R.drawable.pama));
        dataModelShops.add(new RowDataModelShops("Smart Supermarket Birkirkara", R.drawable.smart));

        customAdapterShops = new CustomAdapterShops(dataModelShops,getApplicationContext());
        shopList.setAdapter(customAdapterShops);

        shopList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RowDataModelShops clickedRow = dataModelShops.get(position);
                Toast.makeText(ShopsActivity.this, clickedRow.getItem(), Toast.LENGTH_SHORT).show();
                visitMap(position);
            }
        });
    }

    public void visitMap(int shopChosen){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("shop_id", shopChosen);
        startActivity(intent);
    }
}

