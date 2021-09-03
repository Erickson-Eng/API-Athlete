package com.example.apiathlete.controller;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.dto.request.AthleteDTO;
import com.example.apiathlete.service.AthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/athlete")
public class AthleteController {

    private final AthleteService service;

    @Autowired
    public AthleteController(AthleteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody AthleteDTO obj){
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Athlete> findById(@PathVariable Integer id){
        Athlete obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Athlete>> findAll(){
        List<Athlete> athleteList = service.findAll();
        return ResponseEntity.ok().body(athleteList);
    }
//    @DeleteMapping(path = "/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Integer id){
//        service.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//    @PutMapping(path = "/{id}")
//    public ResponseEntity<Athlete> update(@PathVariable Integer id, @RequestBody Athlete obj){
//        obj = service.update(id, obj);
//        return ResponseEntity.ok().body(obj);
//    }
}
