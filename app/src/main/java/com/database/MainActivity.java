package com.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "Firebase connection Success", Toast.LENGTH_LONG).show();

    }

    public void next(View view) {
        Intent intent = new Intent(this, Patientdata.class);
        startActivity(intent);
        Toast.makeText(MainActivity.this, "You may enter the patients data", Toast.LENGTH_LONG).show();
    }
}
