package com.example.android_week_7;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    private int layout;
    private Context context;
    private List<Contact> contacts;
    private int pos = -1;

    public ContactAdapter(int layout, Context context, List<Contact> contacts) {
        this.layout = layout;
        this.context = context;
        this.contacts = contacts;
    }


    @Override
    public int getCount() {
        return contacts.size();
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
        ConstraintLayout constraintLayout = view.findViewById(R.id.itemList);
        Contact contact = contacts.get(i);
        tvName.setText(contact.getName());
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
        System.out.println(pos);
        return view;
    }
    public void removeItem(DatabaseHandler db) {
        List<Contact> contactsFilter = new ArrayList<>();
        for(Contact contact: contacts) {
            if(contact.getID() != contacts.get(pos).getID()) {
                contactsFilter.add(contact);
            } else {
                db.deleteContact(contact);
            }
        }
        contacts = contactsFilter;
        notifyDataSetChanged();
    }

    public void addItem(Contact contact) {
        contacts.add(contact);
        notifyDataSetChanged();
    }
}
