package com.example.ivan.lesson1.Fragments;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.ivan.lesson1.ActivityButton.StrengthListActivity;
import com.example.ivan.lesson1.CardioButton.CardioActivity;
import com.example.ivan.lesson1.R;

public class FragmentMenu extends Fragment {
    Button activityButton;
    Button cardioButton;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.from(container.getContext()).inflate(R.layout.fragment_menu, container, false);
        initUI(root);
        return root;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void initUI(final View root) {
        activityButton = root.findViewById(R.id.activity_button);
        cardioButton = root.findViewById(R.id.cardio_button);


        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Нажата кнопка", Toast.LENGTH_SHORT).show();
                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(root.findViewById(R.id.activity_button));
                Intent intent = new Intent(getContext(), StrengthListActivity.class);
                startActivity(intent);
            }
        });
        cardioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "нажата кнопка Кирэк", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), CardioActivity.class);
                startActivity(intent);
            }
        });
    }
}
