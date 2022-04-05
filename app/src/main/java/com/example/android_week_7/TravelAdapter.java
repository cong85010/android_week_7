package com.example.android_week_7;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class TravelAdapter extends BaseAdapter {
    private int layout;
    private Context context;
    private List<Travel> travelList;
    private int pos = -1;

    public TravelAdapter(int layout, Context context, List<Travel> travelList, DatabaseHandlerTravel db) {
        this.layout = layout;
        this.context = context;
        this.travelList = travelList;
    }


    @Override
    public int getCount() {
        return travelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       if(view == null) {
        view = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
       }
        TextView tvName = view.findViewById(R.id.tvName);
        ConstraintLayout constraintLayout = view.findViewById(R.id.itemID2);
        Travel travel = travelList.get(i);
        tvName.setText(i + ". " + travel.get_name());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              pos = i;
              notifyDataSetChanged();
            }
        });
        if(pos == i) {
            constraintLayout.setBackgroundColor(Color.BLUE);
        } else {
             constraintLayout.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        }
        ImageButton imageView = (ImageButton) view.findViewById(R.id.imgRemove);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = i;
                removeItem();
            }
        });
        return view;
    }
    public void removeItem() {
        Plan_Visit.db.deleteTravel(travelList.get(pos));
        travelList.remove(pos);
        notifyDataSetChanged();
    }

    public void addItem(Travel travel) {
        travelList.add(travel);
        notifyDataSetChanged();
    }

    public void editItem() {
    }
}
