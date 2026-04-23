package com.example.studentapp.controller;

import com.example.studentapp.model.NoteRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class SummarizeController {

    @PostMapping("/api/summarize/mock")
    public String summarize(@RequestBody NoteRequest request) {

        String text = request.getText();

        // nagyon egyszerű "AI" (demo)
        if (text.length() > 100) {
            return text.substring(0, 100) + "...";
        }

        return text;
    }
}