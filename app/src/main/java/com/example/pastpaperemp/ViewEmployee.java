package com.example.pastpaperemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Adapters.EmployeeAdapter;
import Database.DBHandler;
import Model.Employee;

public class ViewEmployee extends AppCompatActivity {

    ListView listView;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);

        db = new DBHandler(this);
        listView = findViewById(R.id.ListView);

        EmployeeAdapter adapter = new EmployeeAdapter(this);
        listView.setAdapter(adapter);

    }
}
