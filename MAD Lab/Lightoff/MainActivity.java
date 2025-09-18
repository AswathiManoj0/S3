package com.example.frame;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ToggleButton;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Apply insets for status/navigation bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI components
        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView);

        // Toggle logic
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                imageView.setImageResource(R.drawable.lighton); // Light ON
            } else {
                imageView.setImageResource(R.drawable.lightoff); // Light OFF
            }
        });
    }
}
