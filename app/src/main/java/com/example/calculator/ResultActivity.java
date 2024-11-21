package com.example.calculator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    private Spinner spinner;
    private Boolean isLiked = false;
    private ImageButton imageButton;
    private TextView textView;
    private Button button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
            Intent intent = new Intent();
            int data = intent.getIntExtra("key", 0);
            textView = findViewById(R.id.explore_text);
            textView.setText(String.valueOf(data));

            spinner = findViewById(R.id.dropdown);
            imageButton = findViewById(R.id.heart_btn);
            button = findViewById(R.id.btn_next);

            button.setOnClickListener(v -> finishAffinity());

            imageButton.setOnClickListener(v -> {
                if (isLiked){
                    imageButton.setImageResource(R.drawable.img);
                } else {
                    imageButton.setImageResource(R.drawable.heart);
                }
                isLiked = !isLiked;
            });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.dropdown_items, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(0);
    }
}