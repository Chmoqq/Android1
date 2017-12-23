package com.example.ivan.lesson1.ActivityButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.ivan.lesson1.Fragments.WorkoutInfoFragment;
import com.example.ivan.lesson1.R;


public class WorkoutInformationActivity extends AppCompatActivity {
    private static final String WORKOUT_INDEX_KEY = "Index";
    private static int positionWorkout;
    private static boolean orientationCheck;

    public static int getPositionWorkout() {
        return positionWorkout;
    }

    public static String getWorkoutIndexKey() {
        return WORKOUT_INDEX_KEY;
    }

    private WorkoutInfoFragment workoutInfoFragment;
    private FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_info_activity);
        workoutInfoFragment = new WorkoutInfoFragment();
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.activity_container, workoutInfoFragment).commit();
    }

    public static boolean isOrientationCheck() {
        return orientationCheck;
    }

    public static void startPortrait(Context context, int workout_index) {
        Intent intent = new Intent(context, WorkoutInformationActivity.class);
        intent.putExtra(WORKOUT_INDEX_KEY, workout_index);
        context.startActivity(intent);
        orientationCheck = true;

    }

    public static void startLand(int workout_index) {
        positionWorkout = workout_index;
        orientationCheck = false;
    }
}
