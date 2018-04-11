package com.example.kristoforus.healthyself;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class HomeActivity extends AppCompatActivity {

    public Button showDoctorsButton;
    public Button calculateButton;
    public int usedCal, kmWalked;
    private static final String LOG = "HomeActivity";
    private TextView caloriesUsage, welcomeText, kmWalkedTextView;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        caloriesUsage = findViewById(R.id.KKCalTextView);
        kmWalkedTextView = findViewById(R.id.KMTextView);
        showDoctorsButton = findViewById(R.id.DoctorMapBtn);
        calculateButton = findViewById(R.id.CalculateTodayBtn);
        SharedPreferences prefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        caloriesUsage.setText(usedCal + " KKCal"); // Here usedCal represents highscore. You can close the app and the value will still the same. Works with rotate as well.
        welcomeText = findViewById(R.id.WelcomeTextView);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference mref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersRef = mref.child("Users/" + user.getUid());
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users currentUser = dataSnapshot.getValue(Users.class);
                welcomeText.setText("Welcome, " + currentUser.getName());
                kmWalkedTextView.setText(currentUser.getKm_walked() + " KM"); // KM and Calories are now stored and retrieved
                caloriesUsage.setText(currentUser.getCalories_used() + " KKCal");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
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

    public void showDoctors(View view){
        Intent intent = new Intent(this, ShowDoctorsActivity.class);
        startActivity(intent);
    }

    public void calculateToday(View v){
        kmWalked = kmWalked + 1;
        usedCal = kmWalked * 160;
        SharedPreferences sharedPreferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("UsedCal", usedCal);
        editor.apply();

        DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersRef = mRef.child("Users/" + mAuth.getCurrentUser().getUid());
        usersRef.child("calories_used").setValue(usedCal);
        usersRef.child("km_walked").setValue(kmWalked);
        caloriesUsage.setText(usedCal + " KKCal");
        kmWalkedTextView.setText(kmWalked + " KM");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(LOG, "onSaveInstanceState(Bundle) called");
        outState.putInt("UsedCal", usedCal);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(LOG, "onRestoreInstanceState(Bundle) called");
        usedCal = savedInstanceState.getInt("UsedCal", usedCal);
    }

    protected void Logout(View view){
        try{
            mAuth.signOut();
            Toast.makeText(HomeActivity.this, "Logout successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}