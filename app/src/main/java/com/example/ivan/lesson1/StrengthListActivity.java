package com.example.ivan.lesson1;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import java.util.List;

public class StrengthListActivity extends AppCompatActivity {
    private RelativeLayout item1;
    private RelativeLayout item2;
    private RelativeLayout item3;
    private RelativeLayout item4;
    private RelativeLayout item5;
    private RelativeLayout item6;

    private List<RelativeLayout> items;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_list);
        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        item5 = findViewById(R.id.item5);
        item6 = findViewById(R.id.item6);
    }
}
