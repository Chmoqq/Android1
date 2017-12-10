package com.example.ivan.lesson1.ActivityButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.ivan.lesson1.Fragments.FragmentImage;
import com.example.ivan.lesson1.Fragments.TimerFragment;
import com.example.ivan.lesson1.R;
import com.example.ivan.lesson1.model.Workout;
import com.example.ivan.lesson1.model.WorkoutList;

import java.util.List;


public class WorkoutInformationActivity extends AppCompatActivity {
    private static final String WORKOUT_INDEX_KEY = "Index";

    private TextView workOutTitle;
    private TextView workOutDescription;
    private Button startWorkoutBTN;
    private Spinner workoutCount;
    public static Workout currentWorkout;
    private TimerFragment timerFragment;
    private FragmentImage fragmentImage;
    private FragmentManager manager;
    int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_information);
        startWorkoutBTN = findViewById(R.id.workout_button);
        workoutCount = findViewById(R.id.workout_count);

        currentWorkout = WorkoutList.getInstance().getWorkouts().get(
                getIntent().getExtras().getInt(WORKOUT_INDEX_KEY)
        );
        manager = getSupportFragmentManager();
        startWorkoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.workout_button));
                Toast.makeText(WorkoutInformationActivity.this, "Workout started", Toast.LENGTH_SHORT).show();
                count = Integer.parseInt(workoutCount.getSelectedItem().toString());
                currentWorkout.completed(count);
                timerFragment = new TimerFragment();
                manager.beginTransaction().replace(R.id.workout_container, timerFragment).commit();
            }
        });

        workOutTitle = findViewById(R.id.workout_title_text_view);
        workOutDescription = findViewById(R.id.workout_description_text_view);

        workOutTitle.setText(currentWorkout.getTitle());
        workOutDescription.setText(currentWorkout.getDescription());
        fragmentImage = new FragmentImage();
        manager.beginTransaction().add(R.id.workout_container, fragmentImage).commit();

    }

    public static void start(Context context, int workout_index) {
        Intent intent = new Intent(context, WorkoutInformationActivity.class);
        intent.putExtra(WORKOUT_INDEX_KEY, workout_index);
        context.startActivity(intent);
    }
}
