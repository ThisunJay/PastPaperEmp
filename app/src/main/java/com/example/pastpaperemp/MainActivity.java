package com.example.pastpaperemp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onAddEmployee(View view){
        Intent intent = new Intent(MainActivity.this, AddEmployee.class);
        startActivity(intent);
    }

    public void onEditEmployee(View view){
        Intent intent = new Intent(MainActivity.this, EditEmployee.class);
        startActivity(intent);
    }

    public void onViewEmployee(View view){
        Intent intent = new Intent(MainActivity.this, ViewEmployee.class);
        startActivity(intent);
    }
}
