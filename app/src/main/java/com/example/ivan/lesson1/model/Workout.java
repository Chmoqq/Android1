package com.example.ivan.lesson1.model;


public class Workout {
    int title;
    int description;
    int repCount;
    int image;
    int completedCount;

    public int getLastWorkout() {
        return lastWorkout;
    }

    public void setLastWorkout(int lastWorkout) {
        this.lastWorkout = lastWorkout;
    }

    int lastWorkout;

    public int getTitle() {
        return title;
    }

    public int getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }

//    public int getRepCount() {
//        return repCount;
//    }
//
//    public void setRepCount(int repCount) {
//        this.repCount = repCount;
//    }

    public int getCompletedCount() { return this.completedCount; }

    public void completed(int lastWorkout) {
        this.completedCount += 1;
        this.lastWorkout = lastWorkout;
    }

    public Workout(int title, int description, int repCount, int image) {
        this.title = title;
        this.description = description;
        this.repCount = repCount;
        this.image = image;
    }
}
