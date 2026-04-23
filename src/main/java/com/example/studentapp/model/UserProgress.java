package com.example.studentapp.model;

public class UserProgress {

    private int points = 0;
    private int level = 1;
    private int streak = 0;

    public void addPoints(int value) {
        this.points += value;
        updateLevel();
    }

    public void incrementStreak() {
        this.streak++;
    }

    public void resetStreak() {
        this.streak = 0;
    }

    private void updateLevel() {
        this.level = (this.points / 200) + 1;
    }

    public int getPoints() { return points; }
    public int getLevel() { return level; }
    public int getStreak() { return streak; }
}