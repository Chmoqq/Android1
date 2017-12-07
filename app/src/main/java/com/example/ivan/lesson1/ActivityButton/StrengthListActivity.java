package com.example.ivan.lesson1.ActivityButton;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivan.lesson1.R;
import com.example.ivan.lesson1.model.Workout;
import com.example.ivan.lesson1.model.WorkoutList;

import java.util.ArrayList;
import java.util.List;


public class StrengthListActivity extends AppCompatActivity {
    List<StrengthWorkoutViewHolder> children = new ArrayList<>();
    private RecyclerView strength_list;
    private WorkoutAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();

        List<Workout> workoutList = WorkoutList.getInstance().getWorkouts();
        for (int i = 0; i < workoutList.size(); i++) {
            Workout w = workoutList.get(i);

            if (w.getCompletedCount() > 0) {
                children.get(i).recordTextView.setText(String.format("Последний подход %d раз", w.getLastWorkout()));
            } else {
                continue;
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength_list);

        strength_list = findViewById(R.id.strength_list);
        adapter = new WorkoutAdapter(WorkoutList.getInstance().getWorkouts(), this);
        LinearLayoutManager manager = new LinearLayoutManager(this);

        strength_list.setLayoutManager(manager);
        strength_list.setAdapter(adapter);

    }

    private class WorkoutAdapter extends RecyclerView.Adapter<StrengthWorkoutViewHolder> {
        List<Workout> workouts;
        Context context;

        public WorkoutAdapter(List<Workout> workouts, Context context) {
            this.workouts = workouts;
            this.context = context;
        }

        @Override
        public StrengthWorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_workout, parent, false);
            return new StrengthWorkoutViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(StrengthWorkoutViewHolder holder, final int position) {
            children.add(holder);
            holder.imageView.setImageResource(workouts.get(position).getImage());
            holder.titleTextView.setText(workouts.get(position).getTitle());
            if (workouts.get(position).getLastWorkout() == 0) {
                holder.recordTextView.setText("0");
            } else {
                holder.recordTextView.setText(workouts.get(position).getLastWorkout());
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WorkoutInformationActivity.start(context, position);
                }
            });
        }

        @Override
        public int getItemCount() {
            if (workouts != null) {
                return workouts.size();
            } else {
                return 0;
            }
        }
    }

    private class StrengthWorkoutViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView recordTextView;

        public StrengthWorkoutViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.list_item_image_view);
            this.titleTextView = itemView.findViewById(R.id.list_item_title_text_view1);
            this.recordTextView = itemView.findViewById(R.id.last_approach_view);
        }
    }
}