package com.minty.demodocker.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DemoAppDockerController {

    @GetMapping("/test1")
    public ResponseEntity<String> getUsers(){
        return new ResponseEntity<>("Hello from spring boot to Docker :)", HttpStatus.OK);
    }

    @GetMapping("/test2")
    public ResponseEntity<Map<String, Object>> test(){

        Map<String, Object> data = new HashMap<>();
        data.put("name","From Docker");
        data.put("counter",786);
        data.put("adress","my adresse");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
