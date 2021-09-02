package com.example.apiathlete.controller;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/athlete")
public class AthleteController {

    private AthleteService service;

    @Autowired
    public AthleteController(AthleteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Athlete obj){
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
