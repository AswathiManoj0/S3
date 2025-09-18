package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        String currentText = display.getText().toString();

        if (buttonText.equals("=")) {
            try {
                double result = evaluate(currentText);
                display.setText(String.valueOf(result));
            } catch (Exception e) {
                display.setText("Error");
            }
            return;
        }

        if ("÷×−+".contains(buttonText)) {
            display.setText(currentText + " " + buttonText + " ");
        } else {
            if (currentText.equals("0") || currentText.equals("Error")) {
                display.setText(buttonText);
            } else {
                display.setText(currentText + buttonText);
            }
        }
    }

    // Evaluate simple expressions like "2 + 3" or "6 ÷ 2"
    private double evaluate(String expression) {
        expression = expression.replace("÷", "/")
                .replace("×", "*")
                .replace("−", "-");

        String[] tokens = expression.split(" ");
        if (tokens.length != 3) return 0;

        double num1 = Double.parseDouble(tokens[0]);
        String op = tokens[1];
        double num2 = Double.parseDouble(tokens[2]);

        switch (op) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/":
                if (num2 == 0) throw new ArithmeticException("Divide by zero");
                return num1 / num2;
            default: return 0;
        }
    }
}
