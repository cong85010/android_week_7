package com.example.android_week_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.listView);
        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
//        Log.d("Insert: ", "Inserting ..");
//        db.addContact(new Contact("Ravi", "9100000000"));
//        db.addContact(new Contact("Srinivas", "9199999999"));
//        db.addContact(new Contact("Tommy", "9522222222"));
//        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

        ContactAdapter contactAdapter = new ContactAdapter(R.layout.item_list, this, contacts);
        listView.setAdapter(contactAdapter);

        Button add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.textName);
                db.addContact(new Contact(editText.getText().toString(), "9100000000"));
                contactAdapter.addItem(new Contact(editText.getText().toString(), "9100000000"));
                contactAdapter.notifyDataSetChanged();
            }
        });
        Button rm = findViewById(R.id.remove);
        rm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactAdapter.removeItem(db);
               }
        });
    }
}
