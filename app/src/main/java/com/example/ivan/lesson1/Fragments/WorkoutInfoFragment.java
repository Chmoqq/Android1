package com.example.ivan.lesson1.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.ivan.lesson1.ActivityButton.WorkoutInformationActivity;
import com.example.ivan.lesson1.R;
import com.example.ivan.lesson1.model.Workout;
import com.example.ivan.lesson1.model.WorkoutList;

import java.util.List;


public class WorkoutInfoFragment extends Fragment {

    private FragmentImage fragmentImage;
    private TextView workOutTitle;
    private TextView workOutDescription;
    private Button startWorkoutBTN;
    private Spinner workoutCount;
    private TimerFragment timerFragment;
    private FragmentManager manager;
    public static Workout currentWorkout;
    private List<Workout> workouts;
    int count;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View workoutInfo = inflater.from(getContext()).inflate(R.layout.workout_information_fragment, container, false);
        fragmentImage = new FragmentImage();
        workouts = WorkoutList.getInstance().getWorkouts();
        manager = getActivity().getSupportFragmentManager();
        if (WorkoutInformationActivity.isOrientationCheck()) {
            currentWorkout = WorkoutList.getInstance().getWorkouts().get(getActivity().getIntent().getExtras().getInt(WorkoutInformationActivity.getWorkoutIndexKey()));
        } else if (WorkoutInformationActivity.getPositionWorkout() != 0) {
            currentWorkout = workouts.get(WorkoutInformationActivity.getPositionWorkout());
        } else {
            currentWorkout = workouts.get(0);
        }
        workoutCount = workoutInfo.findViewById(R.id.workout_count);
        workOutTitle = workoutInfo.findViewById(R.id.workout_title_text_view);
        workOutDescription = workoutInfo.findViewById(R.id.workout_description_text_view);

        workOutTitle.setText(currentWorkout.getTitle());
        workOutDescription.setText(currentWorkout.getDescription());
        initUI(workoutInfo);
        manager.beginTransaction().add(R.id.workout_container, fragmentImage).commit();

        return workoutInfo;
    }

    private void initUI(final View workoutInfo) {
        startWorkoutBTN = workoutInfo.findViewById(R.id.workout_button);
        startWorkoutBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                YoYo.with(Techniques.SlideOutLeft)
                        .duration(500)
                        .repeat(0)
                        .playOn(workoutInfo.findViewById(R.id.workout_container));
                Toast.makeText(getContext(), "Workout started", Toast.LENGTH_SHORT).show();
                count = Integer.parseInt(workoutCount.getSelectedItem().toString());
                currentWorkout.completed(count);
                timerFragment = new TimerFragment();
                manager.beginTransaction().replace(R.id.workout_container, timerFragment).commit();

                YoYo.with(Techniques.SlideInRight)
                        .duration(500)
                        .repeat(0)
                        .playOn(workoutInfo.findViewById(R.id.workout_container));
            }
        });
    }
}
