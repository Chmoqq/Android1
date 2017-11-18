package com.example.ivan.lesson1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button activityButton;
    Button cardioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initUI() {
        activityButton = findViewById(R.id.activity_button);
        cardioButton = findViewById(R.id.cardio_button);


        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Нажата кнопка", Toast.LENGTH_SHORT).show();
            }
        });
        cardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "нажата кнопка Кирэк", Toast.LENGTH_LONG).show();
            }
        });
    }
}
