package com.example.studentapp.controller;

import com.example.studentapp.model.UserProgress;
import com.example.studentapp.service.ProgressService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/progress")
public class ProgressController {

    private final ProgressService service;

    public ProgressController(ProgressService service) {
        this.service = service;
    }

    @PostMapping("/mission")
    public UserProgress completeMission(@RequestBody Map<String, Object> body) {

        String activity = (String) body.get("activity");
        int length = (int) body.get("textLength");

        return service.completeMission(activity, length);
    }

    @GetMapping
    public UserProgress getProgress() {
        return service.getProgress();
    }
}