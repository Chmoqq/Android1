package com.example.ivan.lesson1.ActivityButton;


import android.content.res.Configuration;
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_list);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            fragmentStrengthList = new FragmentStrengthList();
            workoutInfoFragment = new WorkoutInfoFragment();
            manager = getSupportFragmentManager();
            manager.beginTransaction().add(R.id.workout_info_land, workoutInfoFragment).commit();
        } else {
            fragmentStrengthList = new FragmentStrengthList();
        }
    }
}