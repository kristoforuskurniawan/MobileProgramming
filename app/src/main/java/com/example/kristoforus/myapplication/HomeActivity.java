package com.example.kristoforus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    public Button showDoctorsButton;
    public Button updateButton;
    public Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showDoctorsButton = (Button) findViewById(R.id.DoctorMapBtn);
        updateButton = (Button) findViewById(R.id.UpdateDataBtn);
        calculateButton = (Button) findViewById(R.id.CalculateTodayBtn);
    }

    public void showDoctors(View view){
        Intent intent = new Intent(this, ShowDoctorsActivity.class);
        startActivity(intent);
    }

    public void saveState(View v){

    }

}
