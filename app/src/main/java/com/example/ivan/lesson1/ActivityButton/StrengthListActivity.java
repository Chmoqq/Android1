package com.example.ivan.lesson1.ActivityButton;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ivan.lesson1.R;
import com.example.ivan.lesson1.model.Workout;
import com.example.ivan.lesson1.model.WorkoutList;

import java.util.List;


public class StrengthListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_list);

        LinearLayout parent = findViewById(R.id.strength_list);

        List<Workout> workoutList = WorkoutList.getInstance().getWorkouts();
        for (int i = 0; i < workoutList.size(); i++) {
            Workout w = workoutList.get(i);
            View child = View.inflate(this, R.layout.single_workout, null);

            // сеттеры
            ((TextView)child.findViewById(R.id.list_item_title_text_view1)).setText(w.getTitle());
            ((ImageView)child.findViewById(R.id.list_item_image_view)).setImageResource(w.getImage());

            //
            final int index = i;
            child.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WorkoutInformationActivity.start(StrengthListActivity.this, index);
                }
            });

            parent.addView(child);
        }
    }
}