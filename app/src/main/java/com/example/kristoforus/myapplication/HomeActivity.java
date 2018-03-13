package com.example.kristoforus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button showDoctorsButton = (Button) findViewById(R.id.DoctorMapBtn);
    private Button updateButton = (Button) findViewById(R.id.UpdateDataBtn);
    private Button calculateButton = (Button) findViewById(R.id.CalculateTodayBtn);

    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showDoctors(View view){
        intent = new Intent(this, ShowDoctorsActivity.class);
        startActivity(intent);
    }

}
