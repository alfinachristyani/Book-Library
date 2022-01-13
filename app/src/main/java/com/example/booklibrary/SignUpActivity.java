package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    private EditText emailSignUp, usernameSignUp, passwordSignUp;
    private Button signUpButton;
    private databaseLogin myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailSignUp = findViewById(R.id.signupemail);
        usernameSignUp = findViewById(R.id.signupusername);
        passwordSignUp = findViewById(R.id.siguppassword);

        signUpButton = findViewById(R.id.signupbutton);

        myDB = new databaseLogin(this);
        insertUser();
    }

    private void insertUser() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean var = myDB.registerUser(usernameSignUp.getText().toString(), emailSignUp.getText().toString(), passwordSignUp.getText().toString());
                if(var) {
                    Toast.makeText(SignUpActivity.this, "User Registered Successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SignUpActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}