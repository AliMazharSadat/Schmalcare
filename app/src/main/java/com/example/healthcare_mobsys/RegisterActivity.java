package com.example.healthcare_mobsys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirmPassword;
    Button btnRegister;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegisterUsername);
        edEmail = findViewById(R.id.editTextRegisterEmail);
        edPassword = findViewById(R.id.editTextRegisterPassword);
        edConfirmPassword = findViewById(R.id.editTextRegisterConfirmPassword);
        btnRegister = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewAlreadyUser);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm_password = edConfirmPassword.getText().toString();
                //Create Database
                Database db = new Database(getApplicationContext(), "schmalcare", null, 1);
                if (username.length() == 0 || email.length() == 0 || password.length() == 0 || confirm_password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "You have to fill all the details!", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirm_password)){
                    Toast.makeText(getApplicationContext(), "Password and Confirm Password didn't match!", Toast.LENGTH_SHORT).show();
                } else {
                    db.register(username, email, password);
                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    Toast.makeText(getApplicationContext(), "Registration Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
    }
}