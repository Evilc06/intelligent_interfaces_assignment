package com.example.intelligentinterfaces2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RecommenderActivity extends AppCompatActivity {
    ListView itemList;
    String items[] = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
    //arrays for images and text beneath the item could also be added but for now they are going to be left as defaults.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommender);

        itemList = findViewById(R.id.recommended_list);
        CustomAdapter adapter = new CustomAdapter(this, items);
        itemList.setAdapter(adapter);

        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(RecommenderActivity.this, items[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Custom Adapter used for listView
    class CustomAdapter extends ArrayAdapter<String>{
        Context context;
        String [] rItem;
        //images or item descriptions could be added.

        CustomAdapter(Context c, String [] item){
            super(c, R.layout.item_row, R.id.item_text);
            this.context = c;
            this.rItem = item;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.item_row, parent, false);
            TextView item = row.findViewById(R.id.item_text);

            item.setText(rItem[position]);
            return row;
        }
    }
}