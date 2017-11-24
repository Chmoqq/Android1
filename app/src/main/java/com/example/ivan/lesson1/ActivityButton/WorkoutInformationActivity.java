package com.example.ivan.lesson1.ActivityButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivan.lesson1.R;
import com.example.ivan.lesson1.model.Workout;
import com.example.ivan.lesson1.model.WorkoutList;

import java.util.List;


public class WorkoutInformationActivity extends AppCompatActivity {
    private static final String WORKOUT_INDEX_KEY = "Index";
    int workout_number = 0;
    List<Workout> workouts;

    private TextView workOutTitle;
    private TextView workOutDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_information);

        workouts = WorkoutList.getInstance().getWorkouts();

        workOutTitle = findViewById(R.id.workout_title_text_view);
        workOutDescription = findViewById(R.id.workout_description_text_view);

        Intent intent = getIntent();
        workout_number = intent.getExtras().getInt(WORKOUT_INDEX_KEY);

        Workout workout = workouts.get(workout_number);

        workOutTitle.setText(workout.getTitle());
        workOutDescription.setText(workout.getDescription());
        ImageView workoutImage = findViewById(R.id.workout_image_view);
        workoutImage.setImageResource(workout.getImage());

    }

    public static void start(Context context, int workout_index) {
        Intent intent = new Intent(context, WorkoutInformationActivity.class);
        intent.putExtra(WORKOUT_INDEX_KEY, workout_index);
        context.startActivity(intent);
    }
}
