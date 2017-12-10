package com.example.ivan.lesson1.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.ivan.lesson1.R;

public class TimerFragment extends Fragment implements View.OnClickListener {

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    private Button res;
    private Button str;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
    }

    @Override
    public void onStop() {
        super.onStop();
        wasRunning = running;
        running = false;
    }

    private Button stp;

    @Override
    public void onStart() {
        super.onStart();
        if (wasRunning == true) {
            running = true;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.from(getContext()).inflate(R.layout.timer_fragment, container, false);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
        }
        res = root.findViewById(R.id.button);
        str = root.findViewById(R.id.button3);
        stp = root.findViewById(R.id.button2);
        res.setOnClickListener(this);
        str.setOnClickListener(this);
        stp.setOnClickListener(this);
        runTimer(root);

        return root;
    }

    private void runTimer(View root) {
        final TextView timeView = root.findViewById(R.id.textView);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (running) {
                    seconds++;
                }
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                int miliSecs = (seconds % 60) / 60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                handler.postDelayed(this, 1000);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view.equals(res)) {
            running = false;
            seconds = 0;
            return;
        }
        if (view.equals(str)) {
            running = true;
        }
        if (view.equals(stp)) {
            running = false;
        }
    }
}
