package com.example.kristoforus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    public EditText nameInput;
    public EditText passInput;
    public EditText posInput;
    public String userName, userPassword, userPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameInput = (EditText) findViewById(R.id.NameInput);
        passInput = (EditText) findViewById(R.id.PasswordInput);
        posInput = (EditText) findViewById(R.id.PositionInput);
        userName = nameInput.getText().toString();
        userPassword = passInput.getText().toString();
        userPosition = posInput.getText().toString();
    }

    public void changeActivity(View view){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("username", nameInput.getText().toString());
        intent.putExtra("password", passInput.getText().toString());
        intent.putExtra("position", posInput.getText().toString());
        startActivity(intent);
    }


}
