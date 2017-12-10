package com.example.ivan.lesson1.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ivan.lesson1.ActivityButton.WorkoutInformationActivity;
import com.example.ivan.lesson1.R;


public class FragmentImage extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentImageView = inflater.from(getContext()).inflate(R.layout.image_fragment, container, false);


        ImageView workoutImage = fragmentImageView.findViewById(R.id.workout_image_view);
        workoutImage.setImageResource(WorkoutInformationActivity.currentWorkout.getImage());
        return fragmentImageView;
    }

//    private void setImage() {
//        ImageView workoutImage = f
//    }
//
}
