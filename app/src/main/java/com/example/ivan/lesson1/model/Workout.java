package com.example.ivan.lesson1.model;

/**
 * Created by Ivan on 20.11.2017.
 */

public class Workout {
    int title;
    int description;
    int repCount;

    public int getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public int getRepCount() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount = repCount;
    }


    public Workout(int title, int description, int repCount) {
        this.title = title;
        this.description = description;
        this.repCount = repCount;
    }
}
