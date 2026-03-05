package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText userInputField1;
    private EditText userInputField2;
    private TextView outputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        userInputField1 = findViewById(R.id.inputNumOne);
        userInputField2 = findViewById(R.id.inputNumTwo);
        outputField = findViewById(R.id.numOutput);
    }

    public void sumTwoNumbers(View view) {
        String input1 = userInputField1.getText().toString();
        String input2 = userInputField2.getText().toString();

        if (!input1.isEmpty() && !input2.isEmpty()) {
            int value1 = Integer.parseInt(input1);
            int value2 = Integer.parseInt(input2);
            outputField.setText(String.valueOf(value1 + value2));
        } else {
            Toast.makeText(this, "One or two number fields currently empty", Toast.LENGTH_LONG).show();
            outputField.setText("");
        }
    }

}