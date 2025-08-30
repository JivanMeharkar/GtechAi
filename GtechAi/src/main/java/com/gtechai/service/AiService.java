package com.gtechai.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class AiService {

    @Value("${gemini.api.key}")
    private String geminiApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public String ask(String message) {
        try {
            String url = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=" + geminiApiKey;

            // Gemini request body बनाना
            Map<String, Object> part = new HashMap<>();
            part.put("text", message);

            Map<String, Object> content = new HashMap<>();
            content.put("parts", Collections.singletonList(part));

            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("contents", Collections.singletonList(content));

            // Headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

            Map result = response.getBody();

            // 🔹 Response Parsing
            if (result != null && result.containsKey("candidates")) {
                Object cands = result.get("candidates");
                if (cands instanceof List && !((List<?>) cands).isEmpty()) {
                    Object first = ((List) cands).get(0);
                    if (first instanceof Map) {
                        Map firstMap = (Map) first;
                        Object contentResp = firstMap.get("content");
                        if (contentResp instanceof Map) {
                            Object parts = ((Map) contentResp).get("parts");
                            if (parts instanceof List && !((List<?>) parts).isEmpty()) {
                                Object partResp = ((List) parts).get(0);
                                if (partResp instanceof Map && ((Map<?, ?>) partResp).get("text") != null) {
                                    return ((Map) partResp).get("text").toString();
                                }
                            }
                        }
                    }
                }
            }

            return "No valid response from AI";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}
