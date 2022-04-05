package com.example.android_week_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

public class Plan_Visit extends AppCompatActivity {
    static DatabaseHandlerTravel db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_visit);
        ListView listView = (ListView) findViewById(R.id.listview2);
        db = new DatabaseHandlerTravel(this);

        // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addTravel(new Travel("Ravi"));
//        db.addTravel(new Travel("Srinivas"));
//        db.addTravel(new Travel("Tommy"));
//        db.addTravel(new Travel("Karthik"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Travel> travelList = db.getAllTravel();

        for (Travel trv : travelList) {
            String log = "Id: " + trv.get_id() + " ,Name: " + trv.get_name();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        TravelAdapter travelAdapter = new TravelAdapter(R.layout.item_list_2, this, travelList, db);
        listView.setAdapter(travelAdapter);

        Button add = findViewById(R.id.btnsave);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.textTravel);
                db.addTravel(new Travel(editText.getText().toString()));
                travelAdapter.addItem(new Travel(editText.getText().toString()));
                travelAdapter.notifyDataSetChanged();
            }
        });

//        ImageButton  edit = findViewById(R.id.imgedit);
//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                travelAdapter.editItem();
//            }
//        });
//
    }
}