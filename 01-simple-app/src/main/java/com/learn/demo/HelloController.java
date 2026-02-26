package com.learn.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Map<String, String>> hello() {
        Map<String, String> responseResult = Map.of(
                "message", "Hello from Spring boot application",
                "time", Instant.now().toString()
        );
        return ResponseEntity.ok(responseResult);
    }
}
