package com.example.shared_preference;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        tvDisplay = findViewById(R.id.tvDisplay);

        SharedPreferences sp = getSharedPreferences("UserDetails", MODE_PRIVATE);
        String name = sp.getString("Name", "N/A");
        String email = sp.getString("Email", "N/A");
        String password = sp.getString("Password", "N/A");

        String info = "Name: " + name + "\nEmail: " + email + "\nPassword: " + password;
        tvDisplay.setText(info);
    }
}
