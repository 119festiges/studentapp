package com.example.studentapp.controller;

import com.example.studentapp.model.AiRequest;
import com.example.studentapp.service.AiService;
import org.springframework.web.bind.annotation.*;
///http://localhost:8081/index.html
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/process")
    public String process(@RequestBody AiRequest request) {
        return aiService.handle(request.getType(), request.getText());
    }
}