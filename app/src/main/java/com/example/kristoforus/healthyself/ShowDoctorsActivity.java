package com.example.kristoforus.healthyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowDoctorsActivity extends AppCompatActivity {

    private static final String LOG = "ShowDoctorsActivity";
    private ListView doctorListView;
    private ArrayList<String> doctorList;
    private ArrayAdapter<String> doctorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_doctors);
        doctorList = new ArrayList<String>(5);
        //asdfasdf
        /*getDoctorNames(); // This feature is not yet done
        doctorAdapter = new ArrayAdapter<String>(this, R.layout.activity_show_doctors, doctorList);
        doctorListView = findViewById(R.id.doctorList);
        doctorListView.setAdapter(doctorAdapter);*/
    }

    protected void getDoctorNames(){
        doctorList.add("Alfred");
        doctorList.add("Karen");
        doctorList.add("Rachel");
        doctorList.add("Joe");
        doctorList.add("Bugsy");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(LOG, "onStart(Bundle) called");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(LOG, "onStop(Bundle) called");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(LOG, "onPause(Bundle) called");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(LOG, "onDestroy(Bundle) called");
    }

    public void showDoctorsMap(View view) {
        Intent intent = new Intent(this, DoctorsMapActivity.class);
        startActivity(intent);
    }
}