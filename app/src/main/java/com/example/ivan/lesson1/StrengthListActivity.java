package com.example.ivan.lesson1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;


public class StrengthListActivity extends AppCompatActivity {
    private RelativeLayout item1;
    private RelativeLayout item2;
    private RelativeLayout item3;
    private RelativeLayout item4;
    private RelativeLayout item5;
    private RelativeLayout item6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_list);
        item1 = findViewById(R.id.item1);
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StrengthListActivity.this, "1", Toast.LENGTH_SHORT).show();
            }
        });
        item2 = findViewById(R.id.item2);
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StrengthListActivity.this, "2", Toast.LENGTH_SHORT).show();
            }
        });
        item3 = findViewById(R.id.item3);
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StrengthListActivity.this, "3", Toast.LENGTH_SHORT).show();
            }
        });
        item4 = findViewById(R.id.item4);
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StrengthListActivity.this, "4", Toast.LENGTH_SHORT).show();
            }
        });
        item5 = findViewById(R.id.item5);
        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StrengthListActivity.this, "5", Toast.LENGTH_SHORT).show();
            }
        });
        item6 = findViewById(R.id.item6);
        item6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StrengthListActivity.this, "6", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
