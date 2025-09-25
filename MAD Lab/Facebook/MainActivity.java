package com.example.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // load the layout

        email = findViewById(R.id.editTextTextEmailAddress);
        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);

        login.setOnClickListener(v -> {
            String emailInput = email.getText().toString().trim();
            String passwordInput = password.getText().toString().trim();

            if (emailInput.isEmpty()) {
                Toast.makeText(this, "Enter email or mobile", Toast.LENGTH_SHORT).show();
            } else if (passwordInput.isEmpty()) {
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();

                // Open LoginActivity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
