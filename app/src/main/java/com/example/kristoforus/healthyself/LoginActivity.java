package com.example.kristoforus.healthyself;

/**
 *Complete the database in this app!
 */


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    public EditText e_mailInput;
    public EditText passInput;
    public String userEmail, userPassword;
    private static final String LOG = "LoginActivity";

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener firebaseAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        e_mailInput = findViewById(R.id.E_MailInput);
        passInput = findViewById(R.id.PasswordInput);
        mAuth = FirebaseAuth.getInstance();
        firebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    return;
                }
            }
        };
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(LOG, "onStart(Bundle) called");
        mAuth.addAuthStateListener(firebaseAuthListener);
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(LOG, "onStop(Bundle) called");
        mAuth.removeAuthStateListener(firebaseAuthListener);
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

    public void login(View view){
        userEmail = e_mailInput.getText().toString();
        userPassword = passInput.getText().toString();

        // Shows an alert when inputs for login are empty (no input)
        if(userEmail.equals("") || userPassword.equals("")){
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("Please fill all informations!");
            alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    e_mailInput.setSelection(0);
                    passInput.setSelection(1);
                    //posInput.setSelection(2);
                }
            });
            alertDialog.show();
        }else{
            mAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(LoginActivity.this, "Login error!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    public void Register(View view){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

}