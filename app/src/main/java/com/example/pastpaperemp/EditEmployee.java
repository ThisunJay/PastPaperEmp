package com.example.pastpaperemp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import Database.DBHandler;
import Model.Employee;

public class EditEmployee extends AppCompatActivity {

    Button search, edit;
    EditText name_txt, tel_txt, email_txt, id_txt;
    RadioButton male, female;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee);

        db = new DBHandler(this);

        search = findViewById(R.id.searchBtn);
        edit = findViewById(R.id.editBtn);
        name_txt = findViewById(R.id.nameEE);
        tel_txt = findViewById(R.id.telEE);
        email_txt = findViewById(R.id.emailEE);
        id_txt = findViewById(R.id.empIDEE);
        male = findViewById(R.id.maleEE);
        female = findViewById(R.id.femaleEE);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = id_txt.getText().toString().trim();

                ArrayList<Employee> employees = new ArrayList<>();

                Employee emp = new Employee();

                employees = db.search(Integer.parseInt(id), "");

                emp = employees.get(0);

                Toast.makeText(getApplicationContext(), emp.getId() + "", Toast.LENGTH_LONG).show();

                name_txt.setText(emp.getEmpName());
                tel_txt.setText(String.valueOf(emp.getTelephone()));
                email_txt.setText(emp.getEmail());

                if(emp.getGender().equals("Male")){
                    male.setChecked(true);
                    //female.setChecked(false);
                }else if(emp.getGender().equals("Female")){
                    female.setChecked(true);
                    //male.setChecked(false);
                }
            }
        });
    }
}
