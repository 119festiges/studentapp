package com.example.studentapp.service;

import com.example.studentapp.model.UserProgress;
import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    private final UserProgress progress = new UserProgress();

    public UserProgress getProgress() {
        return progress;
    }

    public UserProgress completeMission(String activity, int textLength) {

        int basePoints = switch (activity) {
            case "summarize" -> 50;
            case "keywords" -> 30;
            case "questions" -> 70;
            default -> 20;
        };

        int bonus = textLength / 50;

        progress.addPoints(basePoints + bonus);
        progress.incrementStreak();

        return progress;
    }
}