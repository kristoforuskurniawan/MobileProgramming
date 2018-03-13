package com.example.kristoforus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ShowDoctorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctors);
    }

    public void showDoctorsMap(View view) {
        Intent intent = new Intent(this, DoctorsMapActivity.class);
        startActivity(intent);
    }
}
