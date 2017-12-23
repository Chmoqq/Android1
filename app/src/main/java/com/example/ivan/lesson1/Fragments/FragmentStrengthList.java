package com.example.ivan.lesson1.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;

import com.example.ivan.lesson1.model.Workout;
import com.example.ivan.lesson1.model.WorkoutList;

import java.util.List;


public class FragmentStrengthList extends ListFragment {
    List<Workout> workouts;
    WorkoutViewAdapter adapter;

    @Override
    public void onResume() {
        super.onResume();
        adapter.dataChangedCheck();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        workouts = WorkoutList.getInstance().getWorkouts();

        adapter = new WorkoutViewAdapter(getActivity(), android.R.layout.simple_list_item_1, workouts);
        setListAdapter(adapter);
    }
}
