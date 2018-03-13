package com.example.kristoforus.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText nameInput = (EditText) findViewById(R.id.NameInput);
    private EditText passInput = (EditText) findViewById(R.id.PasswordInput);
    private EditText posInput = (EditText) findViewById(R.id.PositionInput);
    private String userName, userPassword, userPosition;
    protected Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = nameInput.getText().toString();
        userPassword = passInput.getText().toString();
        userPosition = posInput.getText().toString();
    }

    public void changeActivity(View view){
        intent = new Intent(this, HomeActivity.class);
        intent.putExtra("username", userName);
        intent.putExtra("password", userPassword);
        intent.putExtra("position", userPosition);
        startActivity(intent);
    }


}
