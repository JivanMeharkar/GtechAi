package com.gtechai.controller;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gtechai.model.AskRequest;
import com.gtechai.model.AskResponse;
import com.gtechai.service.AiService;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AiController {
	  private final AiService aiService;

	    public AiController(AiService aiService) {
	        this.aiService = aiService;
	    }

	    @PostMapping(value = "/ask", produces = "application/json")
	    public ResponseEntity<AskResponse> ask(@RequestBody @Valid AskRequest request) {
	        String reply = aiService.ask(request.getMessage());
	        return ResponseEntity.ok(new AskResponse(reply));
	    }
}
