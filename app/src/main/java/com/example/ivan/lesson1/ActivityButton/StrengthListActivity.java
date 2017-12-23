package com.example.ivan.lesson1.ActivityButton;


import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ivan.lesson1.Fragments.FragmentStrengthList;
import com.example.ivan.lesson1.Fragments.WorkoutInfoFragment;
import com.example.ivan.lesson1.R;


public class StrengthListActivity extends AppCompatActivity {
    FragmentStrengthList fragmentStrengthList;
    WorkoutInfoFragment workoutInfoFragment;
    android.support.v4.app.FragmentManager manager;

    @Override
    protected void onSaveInstanceState(Bundle state) {
        if (workoutInfoFragment != null && findViewById(R.id.workout_info_land) != null) {
            manager.beginTransaction().remove(workoutInfoFragment).commit();
        }

        super.onSaveInstanceState(state);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_list);

        if (findViewById(R.id.workout_info_land) != null) {
            fragmentStrengthList = new FragmentStrengthList();
            workoutInfoFragment = new WorkoutInfoFragment();

            manager = getSupportFragmentManager();
            manager.beginTransaction().add(R.id.workout_info_land, workoutInfoFragment).commit();
        }
    }
}