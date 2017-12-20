package com.example.ivan.lesson1.Fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ivan.lesson1.ActivityButton.WorkoutInformationActivity;
import com.example.ivan.lesson1.R;
import com.example.ivan.lesson1.model.Workout;

import java.util.List;


public class WorkoutViewAdapter extends ArrayAdapter<Workout> {

    private List<Workout> objects;
    private Context context;

    public void dataChangedCheck() {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getLastWorkout() != 0) {
                notifyDataSetChanged();
            } else {
                continue;
            }
        }
    }


    public WorkoutViewAdapter(Context context, int textViewResourceId, List<Workout> objects_) {
        super(context, textViewResourceId, objects_);
        this.objects = objects_;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_workout, parent, false);
        }

        Workout w = objects.get(position);

        if (w != null) {
            ImageView imageView = itemView.findViewById(R.id.list_item_image_view);
            TextView textView = itemView.findViewById(R.id.list_item_title_text_view1);
            TextView recordTextView = itemView.findViewById(R.id.last_approach_view);

            imageView.setImageResource(w.getImage());
            textView.setText(w.getTitle());

            if (w.getLastWorkout() == 0) {
                recordTextView.setText("Последний подход: 0");
            } else {
                recordTextView.setText(String.format("Последний подход %d раз", w.getLastWorkout()));
            }
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getContext().getResources().getConfiguration().orientation != Configuration.ORIENTATION_LANDSCAPE) {
                        WorkoutInformationActivity.startPortrait(context, position);
                    } else {
                        WorkoutInformationActivity.startLand(position);
                    }
                }
            });

        }
        return itemView;
    }
}