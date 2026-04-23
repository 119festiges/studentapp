package com.example.studentapp.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AiService {

    private final RestTemplate restTemplate = new RestTemplate();

    public String handle(String type, String text) {

        String prompt = switch (type) {

            case "summary" -> """
                You are a strict educational AI assistant.

                TASK:
                Summarize the text in clear and structured paragraphs.

                RULES:
                - No markdown
                - No bullet points
                - No stars or symbols
                - Keep important information

                TEXT:
                """ + text;

            case "keywords" -> """
                Extract only the most important keywords.

                RULES:
                - No formatting
                - No bullets or stars
                - Only comma separated words

                TEXT:
                """ + text;

            case "questions" -> """
                Create study questions from the text.

                RULES:
                - No markdown
                - No bullets or stars
                - Use numbering only (1,2,3)
                - Make them useful for studying

                TEXT:
                """ + text;

            default -> "Summarize this: " + text;
        };

        String url = "http://localhost:11434/api/generate";

        Map<String, Object> request = Map.of(
                "model", "llama3",
                "prompt", prompt,
                "stream", false
        );

        ResponseEntity<Map> response = restTemplate.postForEntity(
                url,
                request,
                Map.class
        );

        Map body = response.getBody();

        if (body == null) return "No response";

        String result = body.get("response").toString();

        return clean(result);
    }

    private String clean(String text) {
        return text
                .replace("*", "")
                .replace("#", "")
                .trim();
    }
}