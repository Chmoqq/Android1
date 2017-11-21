package com.example.ivan.lesson1.model;

import com.example.ivan.lesson1.R;

import java.util.ArrayList;
import java.util.List;


public class WorkoutList {
    private static WorkoutList ourInstance = null;

    private List<Workout> workouts;

    public static WorkoutList getInstance() {
        if (ourInstance == null) {
            ourInstance = new WorkoutList();
            return ourInstance;
        } else {
            return ourInstance;
        }
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    private WorkoutList() {
        initWorkoutList();
    }

    private void initWorkoutList() {
        workouts = new ArrayList<>();
        workouts.add(new Workout(R.string.extension_of_arms_in_slope, R.string.extension_of_arms_in_slope_description, 0, R.drawable.work1));
        workouts.add(new Workout(R.string.Extension_of_arms_from_behind_the_head, R.string.Extension_of_arms_from_behind_the_head_description, 0, R.drawable.work2));
        workouts.add(new Workout(R.string.reverse_pushups, R.string.reverse_pushups_description, 0, R.drawable.work3));
        workouts.add(new Workout(R.string.french_pushups_from_head_behind, R.string.french_pushups_from_head_behind_description, 0, R.drawable.work4));
        workouts.add(new Workout(R.string.Extension_of_the_arm_from_the_chest_lying_down, R.string.Extension_of_the_arm_from_the_chest_lying_down_description, 0, R.drawable.work5));
        workouts.add(new Workout(R.string.Pushups_with_a_narrow_setting_of_hands, R.string.Pushups_with_a_narrow_setting_of_hands_description, 0, R.drawable.work6));
        workouts.add(new Workout(R.string.Hand_bending, R.string.Hand_bending_description, 0, R.drawable.work7));
        workouts.add(new Workout(R.string.Hand_to_hand, R.string.Hand_to_hand_description, 0, R.drawable.work8));
    }

    private void addWorkout(Workout workout) {
        workouts.add(workout);
    }
}
