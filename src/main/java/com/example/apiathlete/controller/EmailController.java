package com.example.apiathlete.controller;

import com.example.apiathlete.domain.Athlete;
import com.example.apiathlete.domain.Email;
import com.example.apiathlete.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private final EmailService service;

    @Autowired
    public EmailController(EmailService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody @Valid Email obj){
        service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Email> findById(@PathVariable Integer id){
        Email obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping
    public ResponseEntity<List<Email>> findAll(){
        List<Email> objList = service.findAll();
        return ResponseEntity.ok().body(objList);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Email> update(@PathVariable Integer id, @RequestBody Email obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
