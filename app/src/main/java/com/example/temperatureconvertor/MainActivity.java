package com.example.temperatureconvertor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editFar, editCel;
    private MaterialButton btnToCel, btnToFahr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editFar = findViewById(R.id.edit_far);
        editCel = findViewById(R.id.edit_cel);
        btnToCel = findViewById(R.id.btn_tocel);
        btnToFahr = findViewById(R.id.btn_tofar);

        btnToCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertToCelsius();
            }
        });

        btnToFahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertToFahrenheit();
            }
        });
    }

    private void convertToCelsius() {
        String fahrString = editFar.getText().toString().trim();
        if (fahrString.isEmpty()) {
            Toast.makeText(this, "Please enter a Fahrenheit value!", Toast.LENGTH_SHORT).show();
            return;
        }
        double fahr = Double.parseDouble(fahrString);
        double cel = (fahr - 32) * 5/9;
        editCel.setText(String.format("%.2f", cel));
    }

    private void convertToFahrenheit() {
        String celString = editCel.getText().toString().trim();
        if (celString.isEmpty()) {
            Toast.makeText(this, "Please enter a Celsius value!", Toast.LENGTH_SHORT).show();
            return;
        }
        double cel = Double.parseDouble(celString);
        double fahr = (cel * 9/5) + 32;
        editFar.setText(String.format("%.2f", fahr));
    }
}