package com.userLogin.controller;

import com.userLogin.model.TestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/private")
public class PublicRestApiController {

    @GetMapping("/test1")
    @CrossOrigin
    public ResponseEntity<?> test1(){
        return ResponseEntity.ok(new TestResponse("API Test 1"));
    }

    @CrossOrigin
    @GetMapping("/test2")
    public ResponseEntity<?> test2(){
        return ResponseEntity.ok(new TestResponse("API Test 1"));
    }
}


