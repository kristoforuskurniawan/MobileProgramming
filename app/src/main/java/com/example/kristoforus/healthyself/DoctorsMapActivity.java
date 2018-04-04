package com.example.kristoforus.healthyself;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class DoctorsMapActivity extends AppCompatActivity {


    public Button homeButton;
    private static final String LOG = "DoctorsMapActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_map);
        homeButton = (Button) findViewById(R.id.HomeButton);
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

    public void goHome(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}