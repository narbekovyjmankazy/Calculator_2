package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer variableA = null, variableB = null;
    private Boolean IsOperationClick = false;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }

    public void OnNumberClick(View view){
        String text = ((MaterialButton) view).getText().toString();

        if (text.equals("AC")){
            textView.setText("0");
            variableA = null;
            variableB = null;
            operator = "";
        } else if (textView.getText().toString().equals("0") || IsOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        IsOperationClick = false;
    }

    public void onOperationClick(View view){
        operator = ((MaterialButton) view).getText().toString();
        try {
            variableA = Integer.valueOf(textView.getText().toString());
        } catch (NumberFormatException e) {
            textView.setText("Ошибка");
            return;
        }
        IsOperationClick = true;
    }

    public void onEqualClick(View view){
        if(operator.isEmpty() || variableA == null){
            textView.setText("Ошибка операции");
            return;
        }

        try {
            variableB = Integer.valueOf(textView.getText().toString());
        } catch (NumberFormatException e){
            textView.setText("Ошибка");
            return;
        }

        int result;
        switch (operator){
            case "+":
                result = variableA + variableB;
                break;
            case "-":
                result = variableA - variableB;
            case  "/":
                if (variableB != 0){
                    result = variableA / variableB;
                } else {
                    textView.setText("На 0 делить нельзя");
                    return;
                }
                break;
            default:
                textView.setText("Ошибка");
                return;
        }
        textView.setText(String.valueOf(result));
    }
}