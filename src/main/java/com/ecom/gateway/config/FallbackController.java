package com.ecom.gateway.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @RequestMapping("/fallback")
    public ResponseEntity<String> fallback() {
        return ResponseEntity.status(503).body("Service temporarily unavailable. Please try again later.");
    }
}