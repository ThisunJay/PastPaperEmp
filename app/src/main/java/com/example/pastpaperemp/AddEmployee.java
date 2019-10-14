package com.example.pastpaperemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import Database.DBHandler;

public class AddEmployee extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String type;
    Button addBtn;
    EditText name_txt, tel_txt, email_txt;
    RadioButton male, female;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        db = new DBHandler(this);

        Spinner spinner = findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.empType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);

        addBtn = findViewById(R.id.addEmp);
        name_txt = findViewById(R.id.nameAE);
        tel_txt = findViewById(R.id.telAE);
        email_txt = findViewById(R.id.emailAE);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = name_txt.getText().toString().trim();
                int tel = Integer.parseInt(tel_txt.getText().toString().trim());
                String email = email_txt.getText().toString().trim();
                String gender = "";

                if(male.isChecked()){
                    gender = "Male";
                }
                else if(female.isChecked()){
                    gender = "Female";
                }else {

                }
                boolean res = db.addEmployee(name, tel, gender, email, type);

                if(res == true){
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        type = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
