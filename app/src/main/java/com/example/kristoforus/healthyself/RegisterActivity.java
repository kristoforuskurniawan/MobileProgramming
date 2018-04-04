package com.example.kristoforus.healthyself;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private String Name;
    private String E_Mail;
    private String Password;

    private EditText nameInput;
    private EditText emailInput;
    private EditText passwordInput;
    private RadioButton asUser, asDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        nameInput = findViewById(R.id.NameEditText);
        emailInput = findViewById(R.id.E_Mail_EditText);
        passwordInput = findViewById(R.id.Password_EditText);
        asUser = findViewById(R.id.UserRadioButton);
        asDoctor = findViewById(R.id.DoctorRadioButton);
    }

    public void registerClick(View view) {
        Name = nameInput.getText().toString();
        E_Mail = emailInput.getText().toString();
        Password = passwordInput.getText().toString();
        if(E_Mail.equals("") || Password.equals("") || Name.equals("")){
            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Error");
            alertDialog.setMessage("E-mail or Password cannot be empty!");
            alertDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    /*emailInput.setSelection(0);
                    passwordInput.setSelection(1);*/
                }
            });
            alertDialog.show();
        }else{
            mAuth.createUserWithEmailAndPassword(E_Mail, Password).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registration error!", Toast.LENGTH_SHORT).show();
                    }else{
                        if(asUser.isChecked() && (!asDoctor.isChecked())){ // Registered as user. This feauture is not yet implemented.
                            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
                            DatabaseReference usersRef = mRef.child("Users/" + mAuth.getCurrentUser().getUid());
                            usersRef.child("name").setValue(Name); // name and calories_used is colName from database table
                            usersRef.child("calories_used").setValue(0); // high_score in example
                        }else{ // Registered as doctor
                            DatabaseReference mRef = FirebaseDatabase.getInstance().getReference();
                            DatabaseReference usersRef = mRef.child("Doctors/" + mAuth.getCurrentUser().getUid());
                            usersRef.child("name").setValue(Name); // name and calories_used is colName from database table
                            usersRef.child("calories_used").setValue(0); // high_score in example
                        }
                        Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}