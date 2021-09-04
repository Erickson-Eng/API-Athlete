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
import java.util.stream.Collectors;

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
    public ResponseEntity<List<AthleteDTO>> findAll(){
        List<AthleteDTO> athleteList = service.findAll();
        return ResponseEntity.ok().body(athleteList);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
//    @PutMapping(path = "/{id}")
//    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody AthleteDTO obj){
//        service.replace(id, obj);
//        return ResponseEntity.noContent().build();
//    }
}
