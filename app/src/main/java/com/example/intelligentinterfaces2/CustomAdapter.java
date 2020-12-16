package com.example.intelligentinterfaces2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<RowDataModel> implements View.OnClickListener {
    private ArrayList<RowDataModel> dataset;
    Context mContext;

    private static class ViewHolder {
        TextView itemTxtName;
    }

    public CustomAdapter(ArrayList<RowDataModel> data, Context context){
        super(context, R.layout.item_row, data);
        this.dataset = data;
        this.mContext = context;
    }

    public CustomAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public CustomAdapter(@NonNull Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    public CustomAdapter(@NonNull Context context, int resource, @NonNull RowDataModel[] objects) {
        super(context, resource, objects);
    }

    public CustomAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull RowDataModel[] objects) {
        super(context, resource, textViewResourceId, objects);
    }

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<RowDataModel> objects) {
        super(context, resource, objects);
    }

    public CustomAdapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List<RowDataModel> objects) {
        super(context, resource, textViewResourceId, objects);
    }

    @Override
    public void onClick(View v) {
        int position=(Integer) v.getTag();
        Object object= getItem(position);
        RowDataModel dataModel=(RowDataModel)object;

        switch (v.getId())
        {
            case R.id.item_text:
                Snackbar.make(v, "Item " +dataModel.getItem(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        RowDataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_row, parent, false);
            viewHolder.itemTxtName = (TextView) convertView.findViewById(R.id.item_text);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        result.startAnimation(animation);
        lastPosition = position;

        viewHolder.itemTxtName.setText(dataModel.getItem());

        // Return the completed view to render on screen
        return convertView;
    }
}


