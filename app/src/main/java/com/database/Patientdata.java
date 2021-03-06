package com.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Patientdata extends AppCompatActivity {
    EditText txtName, txtAge, txtTime, txtWt, txtHt, txtWeek;
    Button btnsave;
    DatabaseReference reff;
    Member member;
    String name;
    int age,agea,weight,height,week;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patientdata);
        txtName=(EditText)findViewById(R.id.txtName);
        txtAge=(EditText)findViewById(R.id.txtAge);
        txtHt=(EditText) findViewById(R.id.txtHt);
        txtWt=(EditText) findViewById(R.id.txtWt);
        txtWeek=(EditText) findViewById(R.id.txtWeek);
        btnsave=(Button)findViewById(R.id.btnsave);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = Integer.parseInt(txtWt.getText().toString().trim());
                agea = Integer.parseInt(txtAge.getText().toString().trim());
                height = Integer.parseInt(txtHt.getText().toString().trim());
                week = Integer.parseInt(txtWeek.getText().toString().trim());
                name = txtName.getText().toString();
                age = Integer.parseInt(txtAge.getText().toString());
                member.setHeight(height);
                member.setAge(agea);
                member.setWeight(weight);
                member.setWeeks(week);
                member.setName(txtName.getText().toString().trim());
                reff.push().setValue(member);
                showToast(name);
                showToast(String.valueOf(age));
                Toast.makeText(Patientdata.this,"data inserted successfully",Toast.LENGTH_LONG).show();
            }
        });
    }
    private void showToast(String text) {
        Toast.makeText(Patientdata.this, text, Toast.LENGTH_SHORT).show();
    }

}





