package com.example.didongsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    List<Student> contacts;
    DatabaseHandler db;
    AdapterList adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHandler(this);

        // Inserting Contacts
        listView = (ListView) findViewById(R.id.idListView);
        Button btnAdd = findViewById(R.id.button);
        Button btnRe = findViewById(R.id.button2);
        Button btnCan = findViewById(R.id.button3);

        setListView();
        EditText text  = findViewById(R.id.editTextTextPersonName);





        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new Student( text.getText().toString()) );

                setListView();
            }
        });
        // Reading all contacts



        btnRe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = AdapterList.id;
                if(id>0){
                    db.deleteContact(id);
                    setListView();
                }else{

                }


            }
        });


        btnCan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    setListView();
            }
        });
    }





    public void setListView() {
        contacts = db.getAllContacts();
        adapter = new AdapterList(this, R.layout.item_list, contacts);
        listView.setAdapter(adapter);

        for (Student cn : contacts) {
            String log = "Id: " + cn.getId() + " ,Name: " + cn.getName();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

    }
}