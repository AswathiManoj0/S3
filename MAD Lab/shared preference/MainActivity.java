package com.example.shared_preference;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shared_preference.DisplayActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {
            String name = etName.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();

            SharedPreferences sp = getSharedPreferences("UserDetails", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("Name", name);
            editor.putString("Email", email);
            editor.putString("Password", password);
            editor.apply();

            startActivity(new Intent(MainActivity.this, DisplayActivity.class));
        });
    }
}
